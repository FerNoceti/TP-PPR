package com.ppr;

import com.ppr.implementations.AlumnoDaoImp;
import com.ppr.model.Alumno;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlumnoDaoImp alumnoDaoImp = new AlumnoDaoImp();
        alumnoDaoImp.addAlumno(1);
        alumnoDaoImp.addAlumno(2);

        List<Alumno> alumnos = alumnoDaoImp.getAllAlumnos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }

        alumnoDaoImp.deleteAlumno(4);



    }
}