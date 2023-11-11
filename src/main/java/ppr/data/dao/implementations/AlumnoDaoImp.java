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
        return null;
    }

    @Override
    public boolean addAlumno(Alumno alumno) {
        int newPersonaId = super.addPersona(alumno);

        if (newPersonaId == -1 || existeAlumno(newPersonaId)) {
            return false;
        }

        String insertAlumnoQuery = "INSERT INTO alumnos (legajo, id_persona) VALUES (generar_legajo(?, ?), ?)";
        boolean alumnoAgregado = false;

        try (Connection connection = conexionDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertAlumnoQuery)) {

            statement.setString(1, String.valueOf(alumno.getDni()));
            statement.setInt(2, newPersonaId);
            statement.setInt(3, newPersonaId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                alumnoAgregado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.closeConnection();
        }
        return alumnoAgregado;
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

}
