package ppr.model;

public class CursoPresencial extends Curso {
    private int idCursoPresencial;
    private String aula;
    private String fecha;
    private String hora;

    public CursoPresencial(int idCurso, String nombre, int idDocente, String descripcion, String objetivo, String dirigido, int precio, int idCursoPresencial, String aula, String fecha, String hora) {
        super(idCurso, nombre, idDocente, descripcion, objetivo, dirigido, precio);
        this.idCursoPresencial = idCursoPresencial;
        this.aula = aula;
        this.fecha = fecha;
        this.hora = hora;
    }

    public CursoPresencial(){
        super();
    }

    public int getIdCursoPresencial() {
        return idCursoPresencial;
    }

    public void setIdCursoPresencial(int idCursoPresencial) {
        this.idCursoPresencial = idCursoPresencial;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "CursoPresencial{" +
                "idCursoPresencial=" + idCursoPresencial +
                ", aula='" + aula + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
