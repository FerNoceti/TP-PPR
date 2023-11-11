package com.ppr.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Docente extends Persona {
    private int idDocente;
    private String cv;

    public Docente() {
        super(10, 12345678, "Juan", "Perez", LocalDate.now());
    }

    public Docente(int idPersona, int dni, String nombre, String apellido, Timestamp fechaNacimiento, int idDocente, String cv) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento);
        this.idDocente = idDocente;
        this.cv = cv;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return super.toString() + "Docente{" +
                "idDocente=" + idDocente +
                ", cv='" + cv + '\'' +
                '}';
    }
}
