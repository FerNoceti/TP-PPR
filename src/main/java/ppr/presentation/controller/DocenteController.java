package ppr.presentation.controller;

import ppr.logic.service.implementations.DocenteServiceImp;
import ppr.model.Docente;
import ppr.presentation.view.DocenteView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.List;

public class DocenteController {
    private DocenteView view;

    DocenteServiceImp docenteServiceImp = DocenteServiceImp.getInstance();

    public DocenteController(DocenteView view) {
        this.view = view;
        cargarTablaDocentes();
        cargarUltimoIdPersona();
        cargarUltimoIdDocente();
        attachEventListeners();
    }

    private void attachEventListeners() {
        view.getButtonSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarDocente();
                disableTextFields();
            }
        });

        view.getButtonClear().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
                enableTextFields();
                cargarUltimoIdPersona();
                cargarUltimoIdDocente();
            }
        });

        view.getButtonBuscarTodos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarTablaDocentes();
            }
        });

        view.getAgregarDocente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDocente();
                cargarTablaDocentes();
            }
        });
    }

    private DefaultTableModel convertirTableModel(List<Docente> docentes) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{
                        "ID", "Nombre", "Apellido", "DNI", "Fecha de nacimiento", "Edad", "ID Docente", "CV"},
                0

        );

        tableModel.addRow(new Object[]{"ID Persona", "Nombre", "Apellido", "DNI", "Fecha de nacimiento", "Edad", "ID Docente", "CV"});

        for (Docente docente : docentes) {
            Object[] fila = new Object[8];
            fila[0] = docente.getIdPersona();
            fila[1] = docente.getDni();
            fila[2] = docente.getNombre();
            fila[3] = docente.getApellido();
            fila[4] = docente.getFechaNacimiento();
            fila[5] = docente.calcularEdad();
            fila[6] = docente.getIdDocente();
            fila[7] = docente.getCv();
            tableModel.addRow(fila);
        }

        return tableModel;
    }

    private void cargarUltimoIdDocente() {
        view.getTextFieldIdDocente().setText(String.valueOf(docenteServiceImp.obtenerUltimoIdDocente() + 1));
    }

    private void cargarUltimoIdPersona() {
        view.getTextFieldIdPersona().setText(String.valueOf(docenteServiceImp.obtenerUltimoIdPersona() + 1));
    }

    private void cargarTablaDocentes() {
        List<Docente> docentes = docenteServiceImp.getAllDocentes();
        DefaultTableModel tableModel = convertirTableModel(docentes);
        view.getTableDocentes().setModel(tableModel);
    }

    private void cargarDocente() {
        int idPersona = Integer.parseInt(view.getTextFieldIdPersona().getText());
        int dni = Integer.parseInt(view.getTextFieldDNI().getText());
        String nombre = view.getTextFieldNombre().getText();
        String apellido = view.getTextFieldApellido().getText();
        String fechaNacimiento = view.getTextFieldFechaNacimiento().getText();
        Timestamp fechaNacimientoTimestamp = Timestamp.valueOf(fechaNacimiento);
        int idDocente = Integer.parseInt(view.getTextFieldIdDocente().getText());
        String cv = view.getTextFieldCV().getText();

        Docente docente = new Docente(idPersona, dni, nombre, apellido, fechaNacimientoTimestamp, idDocente, cv);
        docenteServiceImp.addDocente(docente);
    }

    private void limpiarCampos() {
    }

    private void buscarDocente() {
    }

    private void disableTextFields() {
    }

    private void enableTextFields() {
    }
}
