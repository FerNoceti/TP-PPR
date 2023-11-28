package ppr.logic.service.interfaces;

import ppr.model.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> getAllAlumnos();

    Alumno getAlumno(int id);

    void addAlumno(Alumno alumno);

    void updateAlumno(Alumno alumno);

    void deleteAlumno(int idAlumno);

    int obtenerUltimoIdAlumno();

    int obtenerUltimoIdPersona();
}
