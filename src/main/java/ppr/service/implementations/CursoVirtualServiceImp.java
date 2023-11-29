package ppr.service.implementations;

import ppr.data.dao.implementations.CursoVirtualDaoImp;
import ppr.data.dao.interfaces.CursoVirtualDao;
import ppr.model.CursoVirtual;
import ppr.service.interfaces.CursoVirtualService;

import java.util.List;

public class CursoVirtualServiceImp implements CursoVirtualService {

    private static CursoVirtualServiceImp instance;

    private final CursoVirtualDao cursoVirtualDao;

    private CursoVirtualServiceImp() {
        super();
        this.cursoVirtualDao = new CursoVirtualDaoImp();
    }

    public static CursoVirtualServiceImp getInstance() {
        if (instance == null) {
            synchronized (CursoVirtualServiceImp.class) {
                if (instance == null) {
                    instance = new CursoVirtualServiceImp();
                }
            }
        }
        return instance;
    }

    @Override
    public List<CursoVirtual> getAllCursosVirtuales() {
        return cursoVirtualDao.getAllCursosVirtuales();
    }

    @Override
    public CursoVirtual getCursoVirtual(int id) {
        CursoVirtual cursoVirtual = cursoVirtualDao.getCursoVirtual(id);

        if (cursoVirtual != null) {
            return cursoVirtual;
        } else {
            System.out.printf("No existe curso virtual con id %d\n", id);
            return null;
        }
    }

    @Override
    public void addCursoVirtual(CursoVirtual cursoVirtual) {
        if (cursoVirtualDao.existeCursoVirtual(cursoVirtual.getIdCurso())) {
            System.out.printf("Ya existe un curso virtual con id %d\n", cursoVirtual.getIdCurso());
        } else {
            boolean cursoVirtualAgregado = cursoVirtualDao.addCursoVirtual(cursoVirtual);
            if (cursoVirtualAgregado) {
                System.out.println("Curso virtual agregado correctamente");
            } else {
                System.out.println("No se pudo agregar el curso virtual");
            }
        }

    }

    @Override
    public void updateCursoVirtual(CursoVirtual cursoVirtual) {

    }

    @Override
    public void deleteCursoVirtual(int idCursoVirtual) {

    }

    @Override
    public int obtenerUltimoIdCursoVirtual() {
        return 0;
    }

    @Override
    public int obtenerUltimoIdCurso() {
        return 0;
    }
}
