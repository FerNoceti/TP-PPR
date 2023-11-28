package ppr.logic.service.interfaces;

import ppr.model.CursoVirtual;

import java.util.List;

public interface CursoVirtualService {
    List<CursoVirtual> getAllCursosVirtuales();

    CursoVirtual getCursoVirtual(int id);

    void addCursoVirtual(CursoVirtual cursoVirtual);

    void updateCursoVirtual(CursoVirtual cursoVirtual);

    void deleteCursoVirtual(int idCursoVirtual);

    int obtenerUltimoIdCursoVirtual();

    int obtenerUltimoIdCurso();
}
