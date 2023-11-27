package ppr.data.dao.interfaces;

import ppr.model.CursoVirtual;

import java.util.List;

public interface CursoVirtualDao extends CursoDao {
    List<CursoVirtual> getAllCursosVirtuales();
    CursoVirtual getCursoVirtual(int id);
    boolean addCursoVirtual(CursoVirtual cursoVirtual);
    void updateCursoVirtual(CursoVirtual cursoVirtual);
    boolean deleteCursoVirtual(int id);
    int obtenerUltimoIdCursoVirtual();
    boolean existeCursoVirtual(int idCurso);
}
