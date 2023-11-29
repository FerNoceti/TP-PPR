package ppr.data.dao.interfaces;

import ppr.model.Persona;

import java.util.List;

public interface PersonaDao {

    List<Persona> getPersonas();

    boolean addPersona(Persona persona);

    void deletePersona(int idPersona);

    Persona getPersona(int idPersona);

    int getDni(int idPersona);

    boolean existePersona(int dni);

    int obtenerUltimoIdPersona();
}
