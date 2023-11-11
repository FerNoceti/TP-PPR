package ppr.main;

import ppr.logic.service.implementations.AlumnoServiceImp;
import ppr.model.Alumno;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setDni(1234);
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setFechaNacimiento(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        AlumnoServiceImp alumnoServiceImp = AlumnoServiceImp.getInstance();
        alumnoServiceImp.addAlumno(alumno);
    }
}