package ppr.presentation.controller;

import ppr.model.Alumno;
import ppr.presentation.view.AlumnoView;
import ppr.service.implementations.AlumnoServiceImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.List;

public class AlumnoController {
    private final AlumnoView view;
    AlumnoServiceImp alumnoServiceImp = AlumnoServiceImp.getInstance();

    public AlumnoController(AlumnoView view) {
        this.view = view;
        cargarTablaAlumnos();
        cargarUltimoIdPersona();
        cargarUltimoIdAlumno();
        attachEventListeners();
    }

    private void attachEventListeners() {
        view.getButtonSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarAlumno();
                disableTextFields();
            }
        });

        view.getButtonClear().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
                enableTextFields();
                cargarUltimoIdPersona();
                cargarUltimoIdAlumno();
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
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "DNI", "Nombre", "Apellido", "Fecha de nacimiento", "Edad", "ID Alumno", "Legajo"},
                0
        );

        modelo.addRow(new Object[]{"ID Persona", "DNI", "Nombre", "Apellido", "Fecha de nacimiento", "Edad", "ID Alumno", "Legajo"});

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

    private void cargarAlumno() {
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

    private void buscarAlumno() {
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

        } else {
            JOptionPane.showMessageDialog(null, "No existe alumno con id " + id);
        }
    }

    private void disableTextFields() {
        view.getTextFieldId().setEnabled(false);
        view.getTextFieldDNI().setEnabled(false);
        view.getTextFieldNombre().setEnabled(false);
        view.getTextFieldApellido().setEnabled(false);
        view.getTextFieldFechaNac().setEnabled(false);
        view.getTextFieldEdad().setEnabled(false);
        view.getTextFieldIdAlumno().setEnabled(false);
        view.getTextFieldLegajo().setEnabled(false);
    }

    private void enableTextFields() {
        view.getTextFieldId().setEnabled(true);
        view.getTextFieldDNI().setEnabled(true);
        view.getTextFieldNombre().setEnabled(true);
        view.getTextFieldApellido().setEnabled(true);
        view.getTextFieldFechaNac().setEnabled(true);
        view.getTextFieldEdad().setEnabled(true);
        view.getTextFieldIdAlumno().setEnabled(true);
        view.getTextFieldLegajo().setEnabled(true);
    }

    private void cargarUltimoIdAlumno() {
        int idAlumno = alumnoServiceImp.obtenerUltimoIdAlumno();
        view.getTextFieldIdAlumno().setText(String.valueOf(idAlumno + 1));
    }

    private void cargarUltimoIdPersona() {
        int idPersona = alumnoServiceImp.obtenerUltimoIdPersona();
        view.getTextFieldId().setText(String.valueOf(idPersona + 1));
    }

}
