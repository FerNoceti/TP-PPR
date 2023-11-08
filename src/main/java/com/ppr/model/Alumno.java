package com.ppr.model;

import java.time.LocalDate;

public class Alumno extends Persona {
    private int idAlumno;
    private int legajo; // Cambiar el tipo de legajo a int
    private static int contadorAlumnos = 0;

    public Alumno() {
        super();
        this.legajo = generarLegajo();
    }

    public Alumno(int idAlumno) {
        super();
        this.idAlumno = idAlumno;
        this.legajo = generarLegajo();
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getLegajo() {
        return legajo;
    }

    private int generarLegajo() {
        String dniStr = String.valueOf(this.getDni());
        String ultimosTresDigitos;

        if (dniStr.length() >= 3) {
            ultimosTresDigitos = dniStr.substring(dniStr.length() - 3);
        } else {
            ultimosTresDigitos = dniStr;
        }

        int dia = LocalDate.now().getDayOfMonth();
        int mes = LocalDate.now().getMonthValue();

        String diaStr = String.format("%02d", dia);
        String mesStr = String.format("%02d", mes);

        contadorAlumnos++;

        String legajoStr = ultimosTresDigitos + diaStr + contadorAlumnos;
        int legajoInt = Integer.parseInt(legajoStr);

        return legajoInt;
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno{" +
                "idAlumno=" + idAlumno +
                ", legajo=" + legajo +
                '}';
    }
}

