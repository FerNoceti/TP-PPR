package ppr.model;

public class Curso {
    private int idCurso;
    private String nombre;
    private String codigo;
    private int idDocente;
    private String descripcion;
    private String objetivo;
    private String dirigido;
    private int precio;

    public Curso() {
    }

    public Curso(int idCurso, String nombre, String codigo, int idDocente, String descripcion, String objetivo, String dirigido, int precio) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idDocente = idDocente;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dirigido = dirigido;
        this.precio = precio;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
}

