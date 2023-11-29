package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.PersonaDao;
import ppr.data.database.ConexionDB;
import ppr.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImp implements PersonaDao {

    private final ConexionDB conexionDB;

    public PersonaDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<Persona> getPersonas() {
        String query = "SELECT * FROM personas";
        List<Persona> personas = new ArrayList<>();

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt("id_persona"));
                persona.setDni(rs.getInt("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));

                personas.add(persona);
            }

            rs.close();
            statement.close();
            conexionDB.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return personas;
    }


    @Override
    public boolean addPersona(Persona persona) {
        String query = "INSERT INTO personas (id_persona, dni, nombre, apellido, fecha_nacimiento) VALUES (?, ?, ?, ?, ?) RETURNING id_persona";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, persona.getIdPersona());
            statement.setInt(2, persona.getDni());
            statement.setString(3, persona.getNombre());
            statement.setString(4, persona.getApellido());
            statement.setTimestamp(5, persona.getFechaNacimiento());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idPersona = rs.getInt(1);

                rs.close();
                statement.close();
                conexionDB.closeConnection();

                return idPersona != 0;
            }

            rs.close();
            statement.close();
            conexionDB.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
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

    @Override
    public int obtenerUltimoIdPersona() {
        String query = "SELECT MAX(id_persona) FROM personas";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idPersona = rs.getInt(1);

                rs.close();
                statement.close();
                conexionDB.closeConnection();

                return idPersona;
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
