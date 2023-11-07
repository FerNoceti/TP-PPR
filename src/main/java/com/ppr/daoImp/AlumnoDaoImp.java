package com.ppr.daoImp;

import com.ppr.dao.AlumnoDAO;
import com.ppr.db.ConexionDB;
import com.ppr.model.Alumno;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDaoImp implements AlumnoDAO {

    private ConexionDB conexionDB;

    public AlumnoDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        String query = "SELECT * FROM alumnos";
        List<Alumno> alumnos = new ArrayList<>();
        try {
            ResultSet rs = this.conexionDB.runQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setId(rs.getInt("id_alumno"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    alumnos.add(alumno);
                }

                return alumnos;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public Alumno getAlumno(int id) {
        String query = "SELECT * FROM alumnos WHERE id_alumno = " + id;
    }

    @Override
    public void addAlumno(Alumno alumno) {

    }

    @Override
    public void updateAlumno(Alumno alumno) {

    }

    @Override
    public void deleteAlumno(int id) {

    }
}
