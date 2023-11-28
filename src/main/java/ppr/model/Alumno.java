package ppr.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Alumno extends Persona {
    private int idAlumno;
    private int legajo;

    public Alumno() {
        super();
    }

    public Alumno(int idPersona, int dni, String nombre, String apellido, Timestamp fechaNacimiento, int idAlumno) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento);
        this.idAlumno = idAlumno;
        generarLegajo();
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
        String dni = String.valueOf(this.getDni());
        String ultimosTresDigitosDni = dni.substring(dni.length() - 3);

        int fecha = LocalDate.now().getDayOfMonth();
        String ultimosDosDigitosFecha = String.valueOf(fecha);
        if (ultimosDosDigitosFecha.length() == 1) {
            ultimosDosDigitosFecha = "0" + ultimosDosDigitosFecha;
        }

        String idAlumno = String.valueOf(this.getIdAlumno());
        if (idAlumno.length() == 1) {
            idAlumno = "0" + idAlumno;
        }

        this.legajo = Integer.parseInt(ultimosTresDigitosDni + ultimosDosDigitosFecha + idAlumno);
    }

    public int calcularEdad() {
        LocalDate fechaNacimiento = this.getFechaNacimiento().toLocalDateTime().toLocalDate();
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaNacimiento.getMonthValue() > fechaActual.getMonthValue()) {
            edad--;
        } else if (fechaNacimiento.getMonthValue() == fechaActual.getMonthValue()) {
            if (fechaNacimiento.getDayOfMonth() > fechaActual.getDayOfMonth()) {
                edad--;
            }
        }
        return edad;
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno{" +
                "idAlumno=" + idAlumno +
                ", legajo=" + legajo +
                '}';
    }
}

