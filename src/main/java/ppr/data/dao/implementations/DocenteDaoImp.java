package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.DocenteDao;
import ppr.data.database.ConexionDB;
import ppr.model.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocenteDaoImp extends PersonaDaoImp implements DocenteDao {

    private final ConexionDB conexionDB;

    public DocenteDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<Docente> getAllDocentes() {
        String query = "SELECT * FROM docentes d INNER JOIN personas p ON d.id_persona = p.id_persona";
        List<Docente> docentes = new ArrayList<>();
        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Docente docente = new Docente();
                docente.setIdDocente(rs.getInt("id_docente"));
                docente.setDni(rs.getInt("dni"));
                docente.setIdPersona(rs.getInt("id_persona"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellido(rs.getString("apellido"));
                docente.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));

                docentes.add(docente);
            }

            conexionDB.closeResultSet(rs);
            statement.close();
            conexionDB.closeConnection();

            return docentes;
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public Docente getDocente(int id) {
        String query = "SELECT * FROM docentes d INNER JOIN personas p ON d.id_persona = p.id_persona WHERE id_docente = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Docente docente = new Docente();
                docente.setIdDocente(rs.getInt("id_docente"));
                docente.setDni(rs.getInt("dni"));
                docente.setIdPersona(rs.getInt("id_persona"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellido(rs.getString("apellido"));
                docente.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento"));

                conexionDB.closeResultSet(rs);
                statement.close();
                conexionDB.closeConnection();

                return docente;
            } else {
                System.out.printf("No existe docente con id %d\n", id);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public boolean addDocente(Docente docente) {
        super.addPersona(docente);

        String query = "INSERT INTO docentes (id_docente, cv, id_persona) VALUES (?, ?, ?)";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, docente.getIdDocente());
            statement.setString(2, docente.getCv());
            statement.setInt(3, docente.getIdPersona());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Docente agregado exitosamente");
                statement.close();
                conexionDB.closeConnection();
                return true;
            } else {
                System.out.println("No se pudo agregar el docente");
                statement.close();
                conexionDB.closeConnection();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
    }

    @Override
    public void updateDocente(Docente docente) {

    }

    @Override
    public boolean deleteDocente(int id) {
        return false;
    }

    @Override
    public boolean existeDocente(int idPersona) {
        return false;
    }

    @Override
    public int obtenerUltimoIdDocente() {
        String query = "SELECT MAX(id_docente) AS id_docente FROM docentes";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idDocente = rs.getInt("id_docente");

                conexionDB.closeResultSet(rs);
                statement.close();
                conexionDB.closeConnection();

                return idDocente;
            } else {
                System.out.println("No existe ningún docente");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }

        return 0;
    }
}
