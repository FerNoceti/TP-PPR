package ppr.presentation.controller;

import ppr.logic.service.implementations.AlumnoServiceImp;
import ppr.model.Alumno;
import ppr.presentation.view.AlumnoView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.List;

public class AlumnoController {
    private AlumnoView view;
    AlumnoServiceImp alumnoServiceImp = AlumnoServiceImp.getInstance();

    public AlumnoController(AlumnoView view) {
        this.view = view;
        attachEventListeners();
    }

    private void attachEventListeners() {
        view.getButtonSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id = Integer.parseInt(view.getTextFieldIDSearch().getText());
                System.out.printf("Buscando alumno con id %d\n", id);
                Alumno alumno = alumnoServiceImp.getAlumno(id);

                if (alumno != null) {
                    view.getTextFieldId().setText(String.valueOf(alumno.getIdPersona()));
                    view.getTextFieldDNI().setText(String.valueOf(alumno.getDni()));
                    view.getTextFieldNombre().setText(alumno.getNombre());
                    view.getTextFieldApellido().setText(alumno.getApellido());
                    view.getTextFieldFechaNac().setText(alumno.getFechaNacimiento().toString());
                    view.getTextFieldEdad().setText(String.valueOf(alumno.calcularEdad()));
                    view.getTextFieldIdAlumno().setText(String.valueOf(alumno.getIdAlumno()));
                    view.getTextFieldLegajo().setText(String.valueOf(alumno.getLegajo()));
                }
            }
        });

        view.getButtonClear().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }
        });

        view.getButtonGetAllAlumnos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarTablaAlumnos();
            }
        });

        view.getButtonAddAlumno().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarAlumno();
                cargarTablaAlumnos();
            }
        });
    }

    private DefaultTableModel convertirATableModel(List<Alumno> alumnos) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Fecha de nacimiento");
        modelo.addColumn("Edad");
        modelo.addColumn("ID Alumno");
        modelo.addColumn("Legajo");

        for (Alumno alumno : alumnos) {
            Object[] fila = new Object[8];
            fila[0] = alumno.getIdPersona();
            fila[1] = alumno.getDni();
            fila[2] = alumno.getNombre();
            fila[3] = alumno.getApellido();
            fila[4] = alumno.getFechaNacimiento();
            fila[5] = alumno.calcularEdad();
            fila[6] = alumno.getIdAlumno();
            fila[7] = alumno.getLegajo();
            modelo.addRow(fila);
        }

        return modelo;
    }

    private void limpiarCampos() {
        view.getTextFieldId().setText("");
        view.getTextFieldDNI().setText("");
        view.getTextFieldNombre().setText("");
        view.getTextFieldApellido().setText("");
        view.getTextFieldFechaNac().setText("");
        view.getTextFieldEdad().setText("");
        view.getTextFieldIdAlumno().setText("");
        view.getTextFieldLegajo().setText("");
    }

    private void cargarTablaAlumnos() {
        List<Alumno> alumnos = alumnoServiceImp.getAllAlumnos();
        DefaultTableModel alumnosModel = convertirATableModel(alumnos);
        view.getTableAlumnos().setModel(alumnosModel);
    }

    private void cargarAlumno(){
        int id = Integer.parseInt(view.getTextFieldId().getText());
        int dni = Integer.parseInt(view.getTextFieldDNI().getText());
        String nombre = view.getTextFieldNombre().getText();
        String apellido = view.getTextFieldApellido().getText();
        String fechaNacimiento = view.getTextFieldFechaNac().getText();
        Timestamp fechaNacimientoTimestamp = Timestamp.valueOf(fechaNacimiento);
        int idAlumno = Integer.parseInt(view.getTextFieldIdAlumno().getText());

        Alumno alumno = new Alumno(id, dni, nombre, apellido, fechaNacimientoTimestamp, idAlumno);
        alumnoServiceImp.addAlumno(alumno);
    }

}
