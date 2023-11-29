package ppr.service.implementations;

import ppr.data.dao.implementations.CursoPresencialDaoImp;
import ppr.data.dao.interfaces.CursoPresencialDao;
import ppr.model.CursoPresencial;
import ppr.service.interfaces.CursoPresencialService;

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
        return cursoPresencialDao.getCursoPresencial(id);
    }

    @Override
    public void addCursoPresencial(CursoPresencial cursoPresencial) {
        if (cursoPresencialDao.addCursoPresencial(cursoPresencial)) {
            System.out.println("Curso presencial agregado correctamente");
        } else {
            System.out.println("Error al agregar curso presencial");
        }
    }

    @Override
    public void updateCursoPresencial(CursoPresencial cursoPresencial) {

    }

    @Override
    public void deleteCursoPresencial(int idCursoPresencial) {

    }

    @Override
    public int obtenerUltimoIdCurso() {
        return cursoPresencialDao.obtenerUltimoIdCurso();
    }

    @Override
    public int obtenerUltimoIdCursoPresencial() {
        return cursoPresencialDao.obtenerUltimoIdCursoPresencial();
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
