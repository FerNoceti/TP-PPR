package com.ppr.implementations;

import com.ppr.dao.AlumnoDao;
import com.ppr.db.ConexionDB;
import com.ppr.model.Alumno;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDaoImp implements AlumnoDao {

    private ConexionDB conexionDB;

    public AlumnoDaoImp() {
        super();
        this.conexionDB = new ConexionDB();
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        String query = "SELECT * FROM personas";
        List<Alumno> alumnos = new ArrayList<>();
        try {
            ResultSet rs = this.conexionDB.runQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setNombre(rs.getString("nombre"));

                    alumnos.add(alumno);
                }

                return alumnos;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Alumno getAlumno(int id) {
        return null;
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
