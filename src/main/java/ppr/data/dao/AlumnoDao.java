package ppr.data.dao;

import ppr.model.Alumno;

import java.util.List;

public interface AlumnoDao extends PersonaDao {

    List<Alumno> getAllAlumnos();

    Alumno getAlumno(int id);

    boolean addAlumno(Alumno alumno);

    void updateAlumno(Alumno alumno);

    boolean deleteAlumno(int id);

    boolean existeAlumno(int idPersona);

}
