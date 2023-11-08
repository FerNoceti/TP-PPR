package com.ppr.dao;

import com.ppr.model.Alumno;

import java.util.List;

public interface AlumnoDao {

    public List<Alumno> getAllAlumnos();

    public Alumno getAlumno(int id);

    public void addAlumno(Alumno alumno);

    public void updateAlumno(Alumno alumno);

    public void deleteAlumno(int id);

}
