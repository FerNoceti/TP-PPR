package ppr.model;

public class Curso {
    private int idCurso;
    private String nombre;
    private int idDocente;
    private String descripcion;
    private String objetivo;
    private String dirigido;
    private int precio;

    public Curso(int idCurso, String nombre, int idDocente, String descripcion, String objetivo, String dirigido, int precio) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.idDocente = idDocente;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dirigido = dirigido;
        this.precio = precio;
    }

    public Curso(String nombre, int idDocente, String descripcion, String objetivo, String dirigido, int precio) {
        this.nombre = nombre;
        this.idDocente = idDocente;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dirigido = dirigido;
        this.precio = precio;
    }

    public Curso() {
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDirigido() {
        return dirigido;
    }

    public void setDirigido(String dirigido) {
        this.dirigido = dirigido;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nombre='" + nombre + '\'' +
                ", idDocente=" + idDocente +
                ", descripcion='" + descripcion + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", dirigido='" + dirigido + '\'' +
                ", precio=" + precio +
                '}';
    }
}

