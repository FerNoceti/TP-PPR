package ppr.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Alumno extends Persona {
    private int idAlumno;
    private int legajo;

    public Alumno() {
        super(10, 12345678, "Juan", "Perez", LocalDate.now());
    }

    public Alumno(int idPersona, int dni, String nombre, String apellido, Timestamp fechaNacimiento, int idAlumno, int legajo) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento);
        this.idAlumno = idAlumno;
        this.legajo = legajo;
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

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void generarLegajo() {
        this.legajo = (int) (Math.random() * 1000000);
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno{" +
                "idAlumno=" + idAlumno +
                ", legajo=" + legajo +
                '}';
    }
}

