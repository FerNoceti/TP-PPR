package ppr.model;

import java.sql.Timestamp;

public class CursoVirtual extends Curso {
    private int idCursoVirtual;
    private String link;
    private Timestamp fecha;
    String hora;

    public CursoVirtual() {
        super();
    }

    public int getIdCursoVirtual() {
        return idCursoVirtual;
    }

    public void setIdCursoVirtual(int idCursoVirtual) {
        this.idCursoVirtual = idCursoVirtual;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
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
        return "CursoVirtual{" +
                "idCursoVirtual=" + idCursoVirtual +
                ", link='" + link + '\'' +
                ", fechaInicio=" + fecha +
                ", hora='" + hora + '\'' +
                '}';
    }
}
