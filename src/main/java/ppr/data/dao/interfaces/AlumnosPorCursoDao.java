package ppr.data.dao.interfaces;

public interface AlumnosPorCursoDao {

        int addAlumnoACurso(int idAlumno, int idCurso);

        int deleteAlumnoDeCurso(int idAlumno, int idCurso);

        boolean existeAlumnoEnCurso(int idAlumno, int idCurso);
}
