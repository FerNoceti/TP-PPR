package ppr.service.interfaces;

import ppr.model.Docente;

import java.util.List;

public interface DocenteService {
    List<Docente> getAllDocentes();

    Docente getDocente(int id);

    void addDocente(Docente docente);

    void updateDocente(Docente docente);

    void deleteDocente(int idDocente);

    int obtenerUltimoIdDocente();

    int obtenerUltimoIdPersona();
}
