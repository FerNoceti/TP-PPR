package ppr.service.implementations;

import ppr.data.dao.implementations.PersonaDaoImp;
import ppr.data.dao.interfaces.PersonaDao;
import ppr.model.Alumno;
import ppr.model.Curso;
import ppr.model.Persona;
import ppr.service.interfaces.ConsultasServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class ConsultasSerivceImp implements ConsultasServiceInterface {

    private static ConsultasSerivceImp instance;

    private final PersonaDao personaDao;

    private ConsultasSerivceImp() {
        super();
        this.personaDao = new PersonaDaoImp();
    }

    public static ConsultasSerivceImp getInstance() {
        if (instance == null) {
            synchronized (ConsultasSerivceImp.class) {
                if (instance == null) {
                    instance = new ConsultasSerivceImp();
                }
            }
        }
        return instance;
    }


    @Override
    public Curso getCursoMasAlumnos() {
        return null;
    }

    @Override
    public List<Alumno> getAlumnosConDescuento() {
        return null;
    }

    @Override
    public List<Persona> getCumpleaniosProximos() {
        List<Persona> personas = personaDao.getPersonas();
        List<Persona> cumpleaniosProximos = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.cumpleEnUnaSemana()) {
                cumpleaniosProximos.add(persona);
            }
        }

        return cumpleaniosProximos;
    }
}
