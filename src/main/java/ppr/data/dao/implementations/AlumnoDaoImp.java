package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.AlumnoDao;
import ppr.data.database.ConexionDB;
import ppr.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDaoImp extends PersonaDaoImp implements AlumnoDao {

    private final ConexionDB conexionDB;

    public AlumnoDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        String query = "SELECT * FROM alumnos a INNER JOIN personas p ON a.id_persona = p.id_persona";
        List<Alumno> alumnos = new ArrayList<>();
        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setIdPersona(rs.getInt("id_persona"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));

                alumnos.add(alumno);
            }

            conexionDB.closeResultSet(rs);
            statement.close();
            conexionDB.closeConnection();

            return alumnos;
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public Alumno getAlumno(int id) {
        String query = "SELECT * FROM alumnos a INNER JOIN personas p ON a.id_persona = p.id_persona WHERE id_alumno = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setIdPersona(rs.getInt("id_persona"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));

                rs.close();
                statement.close();
                conexionDB.closeConnection();

                return alumno;
            }

            rs.close();
            statement.close();
            conexionDB.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public boolean addAlumno(Alumno alumno) {
        super.addPersona(alumno);

        String insertAlumnoQuery = "INSERT INTO public.alumnos(id_alumno, legajo, id_persona)  VALUES (?, ?, ?);";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(insertAlumnoQuery);
            statement.setInt(1, alumno.getIdAlumno());
            statement.setInt(2, alumno.getLegajo());
            statement.setInt(3, alumno.getIdPersona());

            int rowsAffected = statement.executeUpdate();

            statement.close();
            conexionDB.closeConnection();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
    }

    @Override
    public void updateAlumno(Alumno alumno) {

    }

    @Override
    public boolean deleteAlumno(int idAlumno) {
        String query = "DELETE FROM alumnos WHERE id_alumno = ?";
        boolean alumnoEliminado = false;

        try {
            ConexionDB conexionDB = new ConexionDB();
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAlumno);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                alumnoEliminado = true;
            }

            statement.close();
            conexionDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return alumnoEliminado;
    }

    @Override
    public boolean existeAlumno(int idPersona) {
        String query = "SELECT * FROM alumnos WHERE id_persona = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idPersona);

            boolean existe = statement.executeQuery().next();

            statement.close();
            conexionDB.closeConnection();

            return existe;
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
    }

    @Override
    public int obtenerUltimoIdAlumno() {
        String query = "SELECT MAX(id_alumno) FROM alumnos";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idAlumno = rs.getInt(1);

                rs.close();
                statement.close();
                conexionDB.closeConnection();

                return idAlumno;
            }

            rs.close();
            statement.close();
            conexionDB.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return 0;
    }

}
