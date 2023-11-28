package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.ConsultasDao;
import ppr.data.database.ConexionDB;
import ppr.model.Alumno;
import ppr.model.Curso;
import ppr.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasDaoImp implements ConsultasDao {

    private final ConexionDB conexionDB;

    public ConsultasDaoImp() {
        this.conexionDB = new ConexionDB();
    }
    @Override
    public List<Curso> getCursosMasAlumnos() {
        return null;
    }

    @Override
    public List<Alumno> getAlumnosConDescuento() {
        return null;
    }

    @Override
    public List<Persona> getCumpleaniosProximos() {
        String query = "SELECT * FROM personas WHERE MONTH(fecha_nacimiento) = MONTH(CURRENT_DATE()) AND DAY(fecha_nacimiento) >= DAY(CURRENT_DATE()) AND DAY(fecha_nacimiento) <= DAY(CURRENT_DATE() + INTERVAL 7 DAY)";
        List<Persona> personas = new ArrayList<>();

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt("id_persona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));
                persona.setDni(rs.getInt("dni"));

                personas.add(persona);
            }

            conexionDB.closeResultSet(rs);
            statement.close();
            conexionDB.closeConnection();

            return personas;
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;

    }
}
