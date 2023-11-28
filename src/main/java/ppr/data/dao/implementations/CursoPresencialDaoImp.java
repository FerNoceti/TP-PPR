package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.CursoPresencialDao;
import ppr.data.database.ConexionDB;
import ppr.model.CursoPresencial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoPresencialDaoImp extends CursoDaoImp implements CursoPresencialDao {

    private final ConexionDB conexionDB;

    public CursoPresencialDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<CursoPresencial> getAllCursosPresenciales() {
        String query = "SELECT * FROM cursos_presencial cp INNER JOIN cursos c ON cp.id_curso = c.id_curso";
        List<CursoPresencial> cursosPresenciales = new ArrayList<>();

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                CursoPresencial cursoPresencial = new CursoPresencial();

                cursoPresencial.setIdCurso(rs.getInt("id_curso"));
                cursoPresencial.setNombre(rs.getString("nombre"));
                cursoPresencial.setIdDocente(rs.getInt("id_docente"));
                cursoPresencial.setDescripcion(rs.getString("descripcion"));
                cursoPresencial.setObjetivo(rs.getString("objetivo"));
                // TODO Revisar error dirigido
                //cursoPresencial.setDirigido(rs.getString("dirigido"));
                cursoPresencial.setDirigido("dirigido");
                cursoPresencial.setPrecio(rs.getInt("precio"));
                cursoPresencial.setCodigo(rs.getString("codigo"));
                cursoPresencial.setAula(rs.getInt("aula"));
                cursoPresencial.setFecha(rs.getString("fecha"));
                cursoPresencial.setHora(rs.getString("hora"));
                cursoPresencial.setIdCursoPresencial(rs.getInt("id_curso-presencial"));

                cursosPresenciales.add(cursoPresencial);
            }

            conexionDB.closeResultSet(rs);
            statement.close();
            conexionDB.closeConnection();

            return cursosPresenciales;
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public CursoPresencial getCursoPresencial(int id) {
        String query = "SELECT * FROM cursos_presencial cp INNER JOIN cursos c ON cp.id_curso = c.id_curso WHERE cp.id_curso = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                CursoPresencial cursoPresencial = new CursoPresencial();

                cursoPresencial.setIdCurso(rs.getInt("id_curso"));
                cursoPresencial.setNombre(rs.getString("nombre"));
                cursoPresencial.setIdDocente(rs.getInt("id_docente"));
                cursoPresencial.setDescripcion(rs.getString("descripcion"));
                cursoPresencial.setObjetivo(rs.getString("objetivo"));
                // TODO Revisar error dirigido
                //cursoPresencial.setDirigido(rs.getString("dirigido"));
                cursoPresencial.setDirigido("dirigido");
                cursoPresencial.setPrecio(rs.getInt("precio"));
                cursoPresencial.setCodigo(rs.getString("codigo"));
                cursoPresencial.setAula(rs.getInt("aula"));
                cursoPresencial.setFecha(rs.getString("fecha"));
                cursoPresencial.setHora(rs.getString("hora"));
                cursoPresencial.setIdCursoPresencial(rs.getInt("id_curso-presencial"));

                conexionDB.closeResultSet(rs);
                statement.close();
                conexionDB.closeConnection();

                return cursoPresencial;
            }

            conexionDB.closeResultSet(rs);
            statement.close();
            conexionDB.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public boolean addCursoPresencial(CursoPresencial cursoPresencial) {
        super.addCurso(cursoPresencial);

        String query = "INSERT INTO cursos_presencial (\"id_curso-presencial\", id_curso, aula, fecha, hora) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cursoPresencial.getIdCursoPresencial());
            statement.setInt(2, cursoPresencial.getIdCurso());
            statement.setInt(3, cursoPresencial.getAula());
            statement.setString(4, cursoPresencial.getFecha());
            statement.setString(5, cursoPresencial.getHora());

            int rowsInserted = statement.executeUpdate();

            statement.close();
            conexionDB.closeConnection();

            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
    }

    @Override
    public void updateCursoPresencial(CursoPresencial cursoPresencial) {

    }

    @Override
    public boolean deleteCursoPresencial(int id) {
        return false;
    }

    @Override
    public boolean existeCursoPresencial(int idCurso) {
        String query = "SELECT * FROM cursos_presencial WHERE id_curso = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCurso);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                conexionDB.closeResultSet(rs);
                statement.close();
                conexionDB.closeConnection();
                return true;
            } else {
                conexionDB.closeResultSet(rs);
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
    public int obtenerUltimoIdCursoPresencial() {
        String query = "SELECT MAX(\"id_curso-presencial\") FROM cursos_presencial";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int idCursoPresencial = rs.getInt(1);

                rs.close();
                statement.close();
                conexionDB.closeConnection();

                return idCursoPresencial;
            }

            rs.close();
            statement.close();
            conexionDB.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return 0;
    }
}
