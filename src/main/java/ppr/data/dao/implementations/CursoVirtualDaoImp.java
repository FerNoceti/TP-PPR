package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.CursoVirtualDao;
import ppr.data.database.ConexionDB;
import ppr.model.CursoVirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoVirtualDaoImp extends CursoDaoImp implements CursoVirtualDao {

    private final ConexionDB conexionDB;

    public CursoVirtualDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<CursoVirtual> getAllCursosVirtuales() {
        String query = "SELECT * FROM cursos_online a INNER JOIN cursos c ON a.id_curso = c.id_curso";
        List<CursoVirtual> cursosVirtuales = new ArrayList<>();
        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                CursoVirtual cursoVirtual = new CursoVirtual();

                cursoVirtual.setIdCurso(rs.getInt("id_curso"));
                cursoVirtual.setNombre(rs.getString("nombre"));
                cursoVirtual.setCodigo(rs.getString("codigo"));
                cursoVirtual.setIdDocente(rs.getInt("id_docente"));
                cursoVirtual.setDescripcion(rs.getString("descripcion"));
                cursoVirtual.setObjetivo(rs.getString("objetivo"));
                cursoVirtual.setDirigido(rs.getString("dirigido"));
                cursoVirtual.setPrecio(rs.getInt("precio"));
                cursoVirtual.setIdCursoVirtual(rs.getInt("id_curso-online"));
                cursoVirtual.setLink(rs.getString("link"));
                cursoVirtual.setFecha(rs.getTimestamp("fecha"));
                cursoVirtual.setHora(rs.getString("hora"));

                cursosVirtuales.add(cursoVirtual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionDB.closeConnection();
        }
        return null;
    }

    @Override
    public CursoVirtual getCursoVirtual(int id) {
        return null;
    }

    @Override
    public boolean addCursoVirtual(CursoVirtual cursoVirtual) {
        super.addCurso(cursoVirtual);

        String query = "INSERT INTO public.cursos_online(id_curso-online, id_curso, link, fecha, hora) VALUES (?, ?, ?, ?, ?);";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cursoVirtual.getIdCursoVirtual());
            statement.setInt(2, cursoVirtual.getIdCurso());
            statement.setString(3, cursoVirtual.getLink());
            statement.setTimestamp(4, cursoVirtual.getFecha());
            statement.setString(5, cursoVirtual.getHora());

            statement.executeUpdate();

            statement.close();
            conexionDB.closeConnection();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            conexionDB.closeConnection();
            return false;
        }
    }

    @Override
    public void updateCursoVirtual(CursoVirtual cursoVirtual) {

    }

    @Override
    public boolean deleteCursoVirtual(int id) {
        return false;
    }

    @Override
    public int obtenerUltimoIdCursoVirtual() {
        return 0;
    }

    @Override
    public boolean existeCursoVirtual(int idCurso) {
        return false;
    }
}
