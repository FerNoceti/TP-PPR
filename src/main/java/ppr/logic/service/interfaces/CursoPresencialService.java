package ppr.logic.service.interfaces;

import ppr.model.CursoPresencial;

import java.util.List;

public interface CursoPresencialService {
    List<CursoPresencial> getAllCursosPresenciales();

    CursoPresencial getCursoPresencial(int id);

    void addCursoPresencial(CursoPresencial cursoPresencial);

    void updateCursoPresencial(CursoPresencial cursoPresencial);

    void deleteCursoPresencial(int idCursoPresencial);

    int obtenerUltimoIdCurso();

    int obtenerUltimoIdCursoPresencial();

    boolean existeCursoPresencial(int idCursoPresencial);

    boolean elCursoPasoLaCapacidadMaxima(int idCursoPresencial);
}
