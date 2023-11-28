package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.AlumnosPorCursoDao;
import ppr.data.database.ConexionDB;
import ppr.model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlumnosPorCursoDaoImp implements AlumnosPorCursoDao {

    private final ConexionDB conexionDB;

    public AlumnosPorCursoDaoImp() {
        this.conexionDB = new ConexionDB();
    }

    @Override
    public boolean addAlumnoACurso(int idAlumno, int idCurso) {
        String query = "INSERT INTO public.alumnos_cursos( alumnoid, cursoid) VALUES (?, ?);";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAlumno);
            statement.setInt(2, idCurso);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Alumno agregado al curso");
            }

            statement.close();
            conexionDB.closeConnection();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
    }

    @Override
    public boolean deleteAlumnoDeCurso(int idAlumno, int idCurso) {
        return false;
    }

    @Override
    public boolean existeAlumnoEnCurso(int idAlumno, int idCurso) {
        String query = "SELECT * FROM alumnos_cursos WHERE alumnoid = ? AND cursoid = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAlumno);
            statement.setInt(2, idCurso);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Alumno agregado al curso");
                resultSet.close();
                statement.close();
                conexionDB.closeConnection();
                return true;
            } else {
                resultSet.close();
                statement.close();
                conexionDB.closeConnection();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return false;
    }

    @Override
    public int getNumAlumnosEnCurso(int idCurso) {
        String query = "SELECT COUNT(*) FROM alumnos_cursos WHERE cursoid = ?";

        try {
            Connection connection = conexionDB.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idCurso);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                resultSet.close();
                statement.close();
                conexionDB.closeConnection();
                return count;
            } else {
                resultSet.close();
                statement.close();
                conexionDB.closeConnection();
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            conexionDB.closeConnection();
        }
        return 0;
    }


    @Override
    public List<Alumno> getAlumnosPorCurso(String query, int idCurso) {
        return null;
    }

    @Override
    public List<Alumno> getIDAlumnosPorCurso(int idCurso) {
        return null;
    }
}
