package com.ppr.implementations;

import com.ppr.dao.AlumnoDao;
import com.ppr.db.ConexionDB;
import com.ppr.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDaoImp implements AlumnoDao {

    private ConexionDB conexionDB;

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
    public void addAlumno(int idPersona) {
        String selectDNIQuery = "SELECT dni FROM personas WHERE id_persona = ?";
        String checkIfAlumnoExistsQuery = "SELECT COUNT(*) as count FROM alumnos WHERE id_persona = ?";

        try {
            ConexionDB conexionDB = new ConexionDB();
            Connection connection = conexionDB.getConnection();

            PreparedStatement checkIfAlumnoExistsStatement = connection.prepareStatement(checkIfAlumnoExistsQuery);
            checkIfAlumnoExistsStatement.setInt(1, idPersona);
            ResultSet existsResultSet = checkIfAlumnoExistsStatement.executeQuery();

            if (existsResultSet.next()) {
                int count = existsResultSet.getInt("count");
                if (count > 0) {
                    System.out.println("El id_persona ya está en la tabla de alumnos.");
                    return;
                }
            }

            PreparedStatement selectStatement = connection.prepareStatement(selectDNIQuery);
            selectStatement.setInt(1, idPersona);

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String insertAlumnoQuery = "INSERT INTO alumnos (legajo, id_persona) VALUES (generar_legajo(?), ?)";

                PreparedStatement insertStatement = connection.prepareStatement(insertAlumnoQuery);
                insertStatement.setString(1, dni);
                insertStatement.setInt(2, idPersona);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Alumno agregado correctamente.");
                } else {
                    System.out.println("No se pudo agregar el alumno.");
                }

                insertStatement.close();
            } else {
                System.out.println("No se encontró el DNI para la persona con id " + idPersona);
            }

            resultSet.close();
            selectStatement.close();
            conexionDB.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al agregar el alumno: " + e.getMessage());
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
}
