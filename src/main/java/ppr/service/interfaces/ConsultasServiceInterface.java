package ppr.service.interfaces;

import ppr.model.Alumno;
import ppr.model.Curso;
import ppr.model.Persona;

import java.util.List;

public interface ConsultasServiceInterface {
    public Curso getCursoMasAlumnos();
    public List<Alumno> getAlumnosConDescuento();
    public List<Persona> getCumpleaniosProximos();
}
