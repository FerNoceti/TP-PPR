package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.PersonaDao;
import ppr.data.database.ConexionDB;
import ppr.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDaoImp implements PersonaDao {

    private final ConexionDB conexionDB;

    public PersonaDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public int addPersona(Persona persona) {

        if (existePersona(persona.getDni())) {
            return -1;
        }

        String query = "INSERT INTO personas (dni, nombre, apellido, fecha_nacimiento) VALUES (?, ?, ?, ?) RETURNING id_persona";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, persona.getDni());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellido());
            statement.setTimestamp(4, persona.getFechaNacimiento());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPersona = generatedKeys.getInt(1);
                        statement.close();
                        conexionDB.closeConnection();
                        return idPersona;
                    } else {
                        throw new SQLException("Creating persona failed, no ID obtained.");
                    }
                }
            } else {
                throw new SQLException("Creating persona failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return -1;
    }

    @Override
    public void deletePersona(int idPersona) {

    }

    @Override
    public Persona getPersona(int idPersona) {
        String query = "SELECT * FROM personas WHERE id_persona = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idPersona);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt("id_persona"));
                persona.setDni(rs.getInt("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));

                rs.close();
                statement.close();
                conexionDB.closeConnection();

                return persona;
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
    public int getDni(int idPersona) {
        return 0;
    }

    @Override
    public boolean existePersona(int dni) {
        String query = "SELECT * FROM personas WHERE dni = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, dni);

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
