package ppr.data.dao.interfaces;

import ppr.model.Persona;

public interface PersonaDao {

    boolean addPersona(Persona persona);

    void deletePersona(int idPersona);

    Persona getPersona(int idPersona);

    int getDni(int idPersona);

    boolean existePersona(int dni);

    int obtenerUltimoIdPersona();
}
