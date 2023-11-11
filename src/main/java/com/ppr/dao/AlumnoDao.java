package com.ppr.dao;

import com.ppr.model.Alumno;

import java.util.List;

public interface AlumnoDao extends PersonaDao {

    List<Alumno> getAllAlumnos();

    Alumno getAlumno(int id);

    void addAlumno(Alumno alumno);

    void updateAlumno(Alumno alumno);

    void deleteAlumno(int id);

    boolean existeAlumno(int idPersona);

}
