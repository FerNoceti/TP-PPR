package ppr.service.implementations;

import ppr.data.dao.implementations.DocenteDaoImp;
import ppr.data.dao.interfaces.DocenteDao;
import ppr.service.interfaces.DocenteService;
import ppr.model.Docente;

import java.util.List;

public class DocenteServiceImp implements DocenteService {

    private static DocenteServiceImp instance;
    private final DocenteDao docenteDao;

    private DocenteServiceImp() {
        super();
        this.docenteDao = new DocenteDaoImp();
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
        if (docenteDao.addDocente(docente)) {
            System.out.println("Docente agregado correctamente");
        } else {
            System.out.println("No se pudo agregar el docente");
        }
    }

    @Override
    public void updateDocente(Docente docente) {

    }

    @Override
    public void deleteDocente(int idDocente) {

    }

    @Override
    public int obtenerUltimoIdDocente() {
        return docenteDao.obtenerUltimoIdDocente();
    }

    @Override
    public int obtenerUltimoIdPersona() {
        return docenteDao.obtenerUltimoIdPersona();
    }
}
