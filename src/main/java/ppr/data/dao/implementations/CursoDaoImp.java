package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.CursoDao;
import ppr.data.database.ConexionDB;
import ppr.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDaoImp implements CursoDao {

    private final ConexionDB conexionDB;

    public CursoDaoImp() {
        super();
        conexionDB = new ConexionDB();
    }

    @Override
    public int addCurso(Curso curso) {

        if (existeCurso(curso.getIdCurso())) {
            return -1;
        }

        String query = "INSERT INTO cursos (idCurso, nombre, id_docente, decripcion, objetivo, dirigido, precio) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id_curso";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, curso.getIdCurso());
            statement.setString(2, curso.getNombre());
            statement.setInt(3, curso.getIdDocente());
            statement.setString(4, curso.getDescripcion());
            statement.setString(5, curso.getObjetivo());
            statement.setString(6, curso.getDirigido());
            statement.setInt(7, curso.getPrecio());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                statement.close();
                conexionDB.closeConnection();
                return curso.getIdCurso();
            } else {
                throw new SQLException("Creating curso failed, no rows affected.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionDB.closeConnection();
        }
        return -1;
    }

    @Override
    public void deleteCurso(int idCurso) {

    }

    @Override
    public Curso getCurso(int idCurso) {
        String query = "SELECT * FROM cursos WHERE id_curso = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCurso);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(resultSet.getInt("id_curso"));
                curso.setNombre(resultSet.getString("nombre"));
                curso.setIdDocente(resultSet.getInt("id_docente"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                curso.setObjetivo(resultSet.getString("objetivo"));
                curso.setDirigido(resultSet.getString("dirigido"));
                curso.setPrecio(resultSet.getInt("precio"));
                statement.close();
                conexionDB.closeConnection();
                return curso;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public boolean existeCurso(int idCurso) {
        return false;
    }
}
