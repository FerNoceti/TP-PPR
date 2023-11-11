package ppr.data.dao;

import ppr.model.Persona;

public interface PersonaDao {

    int addPersona(Persona persona);

    void deletePersona(int idPersona);

    Persona getPersona(int idPersona);

    int getDni(int idPersona);

    boolean existePersona(int dni);
}
