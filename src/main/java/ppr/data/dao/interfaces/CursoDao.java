package ppr.data.dao.interfaces;

import ppr.model.Curso;

public interface CursoDao {

    boolean addCurso(Curso curso);

    void deleteCurso(int idCurso);

    Curso getCurso(int idCurso);

    boolean existeCurso(int idCurso);

    int obtenerUltimoIdCurso();

}
