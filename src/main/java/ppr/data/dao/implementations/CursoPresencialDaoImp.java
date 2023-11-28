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
                cursoPresencial.setDirigido("Alumnos");
                cursoPresencial.setPrecio(rs.getInt("precio"));
                cursoPresencial.setCodigo(rs.getString("codigo").charAt(0));
                cursoPresencial.setAula(rs.getInt("aula"));
                cursoPresencial.setFecha(rs.getString("fecha"));
                cursoPresencial.setHora(rs.getString("hora"));

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
        return null;
    }

    @Override
    public boolean addCursoPresencial(CursoPresencial cursoPresencial) {
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
        return false;
    }
}
