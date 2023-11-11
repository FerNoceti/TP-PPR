package ppr.logic.service;

import ppr.data.dao.AlumnoDao;
import ppr.data.repository.AlumnoRepository;
import ppr.model.Alumno;

import java.util.List;

public class AlumnoServiceImp implements AlumnoService {

    private static AlumnoServiceImp instance;
    private final AlumnoDao alumnoDao;

    private AlumnoServiceImp() {
        super();
        this.alumnoDao = new AlumnoRepository();
    }

    public static AlumnoServiceImp getInstance() {
        if (instance == null) {
            synchronized (AlumnoServiceImp.class) {
                if (instance == null) {
                    instance = new AlumnoServiceImp();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoDao.getAllAlumnos();
    }

    @Override
    public Alumno getAlumno(int id) {
        Alumno alumno = alumnoDao.getAlumno(id);

        if (alumno != null) {
            return alumno;
        } else {
            System.out.printf("No existe alumno con id %d\n", id);
            return null;
        }
    }

    @Override
    public void addAlumno(Alumno alumno) {
        if (alumnoDao.existeAlumno(alumno.getIdPersona())) {
            System.out.printf("Ya existe un alumno con id %d\n", alumno.getIdPersona());
        } else {
            boolean alumnoAgregado = alumnoDao.addAlumno(alumno);
            if (alumnoAgregado) {
                System.out.println("Alumno agregado correctamente");
            } else {
                System.out.println("No se pudo agregar el alumno");
            }
        }
    }

    @Override
    public void updateAlumno(Alumno alumno) {
    }

    @Override
    public void deleteAlumno(int idAlumno) {
        if (alumnoDao.deleteAlumno(idAlumno)) {
            System.out.println("Alumno eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar el alumno");
        }
    }
}
