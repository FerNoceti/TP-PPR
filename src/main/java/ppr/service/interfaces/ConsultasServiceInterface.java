package ppr.service.interfaces;

import ppr.model.Alumno;
import ppr.model.Curso;
import ppr.model.Persona;

import java.util.List;

public interface ConsultasServiceInterface {
    Curso getCursoMasAlumnos();

    List<Alumno> getAlumnosConDescuento();

    List<Persona> getCumpleaniosProximos();
}
