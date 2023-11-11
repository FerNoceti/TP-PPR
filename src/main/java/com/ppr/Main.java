package com.ppr;

import com.ppr.dao.AlumnoDaoImp;
import com.ppr.model.Alumno;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setDni(1234);
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setFechaNacimiento(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        AlumnoDaoImp alumnoDaoImp = new AlumnoDaoImp();
        alumnoDaoImp.addAlumno(alumno);
        alumnoDaoImp.getAllAlumnos().forEach(System.out::println);
    }
}