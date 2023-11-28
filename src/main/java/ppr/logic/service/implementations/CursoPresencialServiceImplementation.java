package ppr.logic.service.implementations;

import ppr.data.dao.implementations.CursoPresencialDaoImp;
import ppr.data.dao.interfaces.CursoPresencialDao;
import ppr.logic.service.interfaces.CursoPresencialService;
import ppr.model.CursoPresencial;

import java.util.List;

public class CursoPresencialServiceImplementation implements CursoPresencialService {

    private static CursoPresencialServiceImplementation instance;

    private final CursoPresencialDao cursoPresencialDao;
    private CursoPresencialServiceImplementation() {
        super();
        this.cursoPresencialDao = new CursoPresencialDaoImp();
    }

    public static CursoPresencialServiceImplementation getInstance() {
        if (instance == null) {
            synchronized (CursoPresencialServiceImplementation.class) {
                if (instance == null) {
                    instance = new CursoPresencialServiceImplementation();
                }
            }
        }
        return instance;
    }


    @Override
    public List<CursoPresencial> getAllCursosPresenciales() {
        return cursoPresencialDao.getAllCursosPresenciales();
    }

    @Override
    public CursoPresencial getCursoPresencial(int id) {
        return null;
    }

    @Override
    public void addCursoPresencial(CursoPresencial cursoPresencial) {

    }

    @Override
    public void updateCursoPresencial(CursoPresencial cursoPresencial) {

    }

    @Override
    public void deleteCursoPresencial(int idCursoPresencial) {

    }

    @Override
    public int obtenerUltimoIdCursoPresencial() {
        return 0;
    }

    @Override
    public boolean existeCursoPresencial(int idCursoPresencial) {
        return false;
    }

    @Override
    public boolean elCursoPasoLaCapacidadMaxima(int idCursoPresencial) {
        return false;
    }
}
