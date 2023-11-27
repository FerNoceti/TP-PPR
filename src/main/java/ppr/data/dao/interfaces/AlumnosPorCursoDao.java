package ppr.data.dao.interfaces;

public interface AlumnosPorCursoDao {

    boolean addAlumnoACurso(int idAlumno, int idCurso);

    boolean deleteAlumnoDeCurso(int idAlumno, int idCurso);

    boolean existeAlumnoEnCurso(int idAlumno, int idCurso);
}
