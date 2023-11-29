package ppr.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Persona {
    private int idPersona;
    private int dni;
    private String nombre;
    private String apellido;
    private Timestamp fechaNacimiento;

    public Persona(int idPersona, int dni, String juan, String perez, LocalDate now) {
        super();
    }

    public Persona(int idPersona, int dni, String nombre, String apellido, Timestamp fechaNacimiento) {
        super();
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
        super();
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.toUpperCase();
    }

    public Timestamp getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Timestamp fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimientoLocal = fechaNacimiento.toLocalDateTime().toLocalDate();

        return fechaNacimientoLocal.until(fechaActual).getYears();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + calcularEdad() +
                '}';
    }

    public boolean cumpleEnUnaSemana() {
        LocalDate fechaActual = LocalDate.now();

        LocalDateTime localDateTime = fechaNacimiento.toLocalDateTime();

        LocalDate fechaNacimientoLocal = localDateTime.toLocalDate();

        long daysUntilBirthday = ChronoUnit.DAYS.between(fechaActual, fechaNacimientoLocal);

        return daysUntilBirthday > 0 && daysUntilBirthday <= 7;
    }

    public int calcularDiasRestantes() {
        LocalDate fechaActual = LocalDate.now();

        LocalDateTime localDateTime = fechaNacimiento.toLocalDateTime();

        LocalDate fechaNacimientoLocal = localDateTime.toLocalDate();

        long daysUntilBirthday = ChronoUnit.DAYS.between(fechaActual, fechaNacimientoLocal);

        return (int) daysUntilBirthday;
    }
}
