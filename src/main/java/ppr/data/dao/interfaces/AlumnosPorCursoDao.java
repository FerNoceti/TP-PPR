package ppr.data.dao.interfaces;

import ppr.model.Alumno;

import java.util.List;

public interface AlumnosPorCursoDao {

    boolean addAlumnoACurso(int idAlumno, int idCurso);

    boolean deleteAlumnoDeCurso(int idAlumno, int idCurso);

    boolean existeAlumnoEnCurso(int idAlumno, int idCurso);

    int getNumAlumnosEnCurso(int idCurso);

    List<Alumno> getAlumnosPorCurso(String query, int idCurso);

    List<Alumno> getIDAlumnosPorCurso(int idCurso);

    int cantDeCursos(int idAlumno);

}
