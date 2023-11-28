package ppr.logic.service.implementations;

import ppr.data.dao.implementations.AlumnosPorCursoDaoImp;
import ppr.data.dao.interfaces.AlumnosPorCursoDao;
import ppr.logic.service.interfaces.AlumnosPorCursoService;
import ppr.model.Alumno;

import java.util.List;

public class AlumnosPorCursoServiceImp implements AlumnosPorCursoService {

    private static AlumnosPorCursoServiceImp instance;
    private final AlumnosPorCursoDao alumnosPorCursoDao;

    private AlumnosPorCursoServiceImp() {
        super();
        this.alumnosPorCursoDao = new AlumnosPorCursoDaoImp();
    }

    public static AlumnosPorCursoServiceImp getInstance() {
        if (instance == null) {
            synchronized (AlumnosPorCursoServiceImp.class) {
                if (instance == null) {
                    instance = new AlumnosPorCursoServiceImp();
                }
            }
        }
        return instance;
    }


    @Override
    public List<Alumno> getAlumnosPorCurso(int idCurso) {
        return alumnosPorCursoDao.getIDAlumnosPorCurso(idCurso);
    }

    @Override
    public List<Integer> getIdAlumnosPorCurso(int idCurso) {
        return null;
    }

    @Override
    public boolean addAlumnoACursoPresencial(int idAlumno, int idCurso) {

        if (alumnosPorCursoDao.existeAlumnoEnCurso(idAlumno, idCurso)) {
            return false;
        }

        return alumnosPorCursoDao.addAlumnoACurso(idAlumno, idCurso);
    }

    @Override
    public boolean deleteAlumnoDeCurso(int idAlumno, int idCurso) {
        return false;
    }

    @Override
    public boolean existeAlumnoEnCurso(int idAlumno, int idCurso) {
        return alumnosPorCursoDao.existeAlumnoEnCurso(idAlumno, idCurso);
    }

    @Override
    public int getNumAlumnosEnCurso(int idCurso) {
        return alumnosPorCursoDao.getNumAlumnosEnCurso(idCurso);
    }

    @Override
    public int descuentoPorCantidadDeCursos(int idCurso) {
        int cantidadDeCursos = alumnosPorCursoDao.cantDeCursos(idCurso);

        return 20 * cantidadDeCursos;
    }

    @Override
    public int alumnoEnOtrosCursos(int idAlumno) {
        return 0;
    }

    @Override
    public boolean addAlumnoACursoVirtual(int idAlumno, int idCurso) {
        return false;
    }

    @Override
    public boolean existeAlumnoEnCursoVirtual(int idAlumno, int idCurso) {
        return false;
    }

    @Override
    public boolean deleteAlumnoDeCursoVirtual(int idAlumno, int idCurso) {
        return false;
    }

    @Override
    public List<Alumno> getAlumnosPorCursoVirtual(int idCurso) {
        return null;
    }

    @Override
    public List<Integer> getIdAlumnosPorCursoVirtual(int idCurso) {
        return null;
    }
}
