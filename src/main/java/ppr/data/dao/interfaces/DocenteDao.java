package ppr.data.dao.interfaces;

import ppr.model.Docente;

import java.util.List;

public interface DocenteDao extends PersonaDao {

    List<Docente> getAllDocentes();

    Docente getDocente(int id);

    boolean addDocente(Docente docente);

    void updateDocente(Docente docente);

    boolean deleteDocente(int id);

    boolean existeDocente(int idPersona);

    int obtenerUltimoIdDocente();
}
