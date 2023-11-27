package ppr.logic.service.implementations;

import ppr.data.dao.interfaces.DocenteDao;
import ppr.logic.service.interfaces.DocenteService;
import ppr.model.Docente;

import java.util.List;

public class DocenteServiceImp implements DocenteService {

    private static DocenteServiceImp instance;
    private final DocenteDao docenteDao;

    private DocenteServiceImp() {
        super();
        this.docenteDao = null;
    }

    public static DocenteServiceImp getInstance() {
        if (instance == null) {
            synchronized (DocenteServiceImp.class) {
                if (instance == null) {
                    instance = new DocenteServiceImp();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Docente> getAllDocentes() {
        return docenteDao.getAllDocentes();
    }

    @Override
    public Docente getDocente(int id) {
        Docente docente = docenteDao.getDocente(id);

        if (docente != null) {
            return docente;
        } else {
            System.out.printf("No existe docente con id %d\n", id);
            return null;
        }
    }

    @Override
    public void addDocente(Docente docente) {

    }

    @Override
    public void updateDocente(Docente docente) {

    }

    @Override
    public void deleteDocente(int idDocente) {

    }

    @Override
    public int obtenerUltimoIdDocente() {
        return 0;
    }

    @Override
    public int obtenerUltimoIdPersona() {
        return 0;
    }
}
