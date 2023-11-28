package ppr.model;

public class AlumnosPorCurso {
    private int id;
    private int idCurso;
    private int idAlumno;

    public AlumnosPorCurso(int id, int idCurso, int idAlumno) {
        this.id = id;
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
    }

    public AlumnosPorCurso(int idCurso, int idAlumno) {
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
    }

    public AlumnosPorCurso() {
        this.id = 0;
        this.idCurso = 0;
        this.idAlumno = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return "AlumnosPorCurso{" +
                "id=" + id +
                ", idCurso=" + idCurso +
                ", idAlumno=" + idAlumno +
                '}';
    }
}
