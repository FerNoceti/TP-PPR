package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.AlumnosPorCursoDao;
import ppr.data.database.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlumnosPorCursoDaoImp implements AlumnosPorCursoDao {

    private final ConexionDB conexionDB;

    public AlumnosPorCursoDaoImp() {
        this.conexionDB = new ConexionDB();
    }

    @Override
    public boolean addAlumnoACurso(int idAlumno, int idCurso) {
        String query = "INSERT INTO public.alumnos_cursos(alumnocursoid, alumnoid, cursoid) VALUES (?, ?, ?);";

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
}
