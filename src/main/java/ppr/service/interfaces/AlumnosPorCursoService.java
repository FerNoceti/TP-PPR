package ppr.service.interfaces;

import ppr.model.Alumno;

import java.util.List;

public interface AlumnosPorCursoService {

        List<Alumno> getAlumnosPorCurso(int idCurso);

        List<Integer> getIdAlumnosPorCurso(int idCurso);

        boolean addAlumnoACursoPresencial(int idAlumno, int idCurso);

        boolean deleteAlumnoDeCurso(int idAlumno, int idCurso);

        boolean existeAlumnoEnCurso(int idAlumno, int idCurso);

        int getNumAlumnosEnCurso(int idCurso);

        int descuentoPorCantidadDeCursos(int idCurso);

        int alumnoEnOtrosCursos(int idAlumno);

        boolean addAlumnoACursoVirtual(int idAlumno, int idCurso);

        boolean existeAlumnoEnCursoVirtual(int idAlumno, int idCurso);

        boolean deleteAlumnoDeCursoVirtual(int idAlumno, int idCurso);

        List<Alumno> getAlumnosPorCursoVirtual(int idCurso);

        List<Integer> getIdAlumnosPorCursoVirtual(int idCurso);
}
