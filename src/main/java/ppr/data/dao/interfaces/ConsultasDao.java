package ppr.data.dao.interfaces;

import ppr.model.Alumno;
import ppr.model.Curso;
import ppr.model.Persona;

import java.util.List;

public interface ConsultasDao {
    List<Curso> getCursosMasAlumnos();

    List<Alumno> getAlumnosConDescuento();

    List<Persona> getCumpleaniosProximos();
}
