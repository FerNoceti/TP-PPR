package ppr.data.dao.implementations;

import ppr.data.dao.interfaces.CursoPresencialDao;
import ppr.model.CursoPresencial;

import java.util.List;

public class CursoPresencialDaoImp extends CursoDaoImp implements CursoPresencialDao {
    @Override
    public List<CursoPresencial> getAllCursosPresenciales() {
        return null;
    }

    @Override
    public CursoPresencial getCursoPresencial(int id) {
        return null;
    }

    @Override
    public boolean addCursoPresencial(CursoPresencial cursoPresencial) {
        return false;
    }

    @Override
    public void updateCursoPresencial(CursoPresencial cursoPresencial) {

    }

    @Override
    public boolean deleteCursoPresencial(int id) {
        return false;
    }

    @Override
    public boolean existeCursoPresencial(int idCurso) {
        return false;
    }
}
