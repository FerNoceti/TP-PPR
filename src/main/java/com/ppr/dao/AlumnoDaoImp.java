package com.ppr.dao;

import com.ppr.db.ConexionDB;
import com.ppr.model.Alumno;

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
    public void addAlumno(Alumno alumno) {

        int newPersonaId = super.addPersona(alumno);

        if (newPersonaId == -1) {
            System.out.println("No se pudo agregar el alumno, la persona ya existe.");
            return;
        }

        if (existeAlumno(newPersonaId)) {
            System.out.println("No se pudo agregar el alumno, el alumno ya existe.");
            return;
        }

        String inserAlumnoQuery = "INSERT INTO alumnos (legajo, id_persona) VALUES (generar_legajo(?, ?), ?)";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(inserAlumnoQuery);
            statement.setString(1, String.valueOf(alumno.getDni()));
            statement.setInt(2, newPersonaId);
            statement.setInt(3, newPersonaId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Alumno agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el alumno.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.closeConnection();
        }
    }


    @Override
    public void updateAlumno(Alumno alumno) {

    }

    @Override
    public void deleteAlumno(int idAlumno) {
        String query = "DELETE FROM alumnos WHERE id_alumno = ?";

        try {
            ConexionDB conexionDB = new ConexionDB();
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAlumno);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Alumno eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el alumno.");
            }

            statement.close();
            conexionDB.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al eliminar el alumno: " + e.getMessage());
        }

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
