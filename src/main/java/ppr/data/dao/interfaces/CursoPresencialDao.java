package ppr.data.dao.interfaces;

import ppr.model.CursoPresencial;

import java.util.List;

public interface CursoPresencialDao extends CursoDao {
    List<CursoPresencial> getAllCursosPresenciales();

    CursoPresencial getCursoPresencial(int id);

    boolean addCursoPresencial(CursoPresencial cursoPresencial);

    void updateCursoPresencial(CursoPresencial cursoPresencial);

    boolean deleteCursoPresencial(int id);

    boolean existeCursoPresencial(int idCurso);
}
