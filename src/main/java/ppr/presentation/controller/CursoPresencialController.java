package ppr.presentation.controller;

import ppr.logic.service.implementations.CursoPresencialServiceImplementation;
import ppr.model.CursoPresencial;
import ppr.presentation.view.CursoPresencialView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CursoPresencialController {

    CursoPresencialServiceImplementation cursoPresencialServiceImplementation = CursoPresencialServiceImplementation.getInstance();

    private final CursoPresencialView view;

    public CursoPresencialController(CursoPresencialView view) {
        this.view = view;
        cargarTablaCursosPresenciales();
        cargarUltimoIdCurso();
        cargarUltimoIdCursoPresencial();
        attachEventListeners();
    }

    private void attachEventListeners() {
        view.getAgregarCursoButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                agregarCursoPresencial();
                cargarTablaCursosPresenciales();
                cargarUltimoIdCursoPresencial();
                cargarUltimoIdCurso();
                limpiarCampos();
            }
        });

        view.getBuscarCursoPorIdButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarCursoPresencial(Integer.parseInt(view.getTextFieldBuscarID().getText()));
            }
        });

        view.getLimpiarCamposButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
                cargarUltimoIdCursoPresencial();
                cargarUltimoIdCurso();
            }
        });
    }

    private void cargarUltimoIdCursoPresencial() {
        view.getTextFieldIDCursoPresencial().setText(String.valueOf(cursoPresencialServiceImplementation.obtenerUltimoIdCursoPresencial() + 1));
    }

    private void cargarUltimoIdCurso() {
        view.getTextFieldIdCurso().setText(String.valueOf(cursoPresencialServiceImplementation.obtenerUltimoIdCurso() + 1));
        
    }

    private void cargarTablaCursosPresenciales() {
        List<CursoPresencial> cursosPresenciales = cursoPresencialServiceImplementation.getAllCursosPresenciales();
        DefaultTableModel tableModel = convertirAFormatoTabla(cursosPresenciales);
        view.getTableCursosPresenciales().setModel(tableModel);
    }

    private DefaultTableModel convertirAFormatoTabla(List<CursoPresencial> cursosPresenciales) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"ID Curso", "Nombre", "ID Docente", "Descripcion", "Objetivo", "Dirigido", "Precio", "Codigo", "ID Curso_Presencial", "Aula", "Fecha", "Hora"},
                0
        );

        tableModel.addRow(new Object[]{"ID Curso", "Nombre", "ID Docente", "Descripcion", "Objetivo", "Dirigido", "Precio", "Codigo", "ID Curso_Presencial", "Aula", "Fecha", "Hora"});

        for (CursoPresencial cursoPresencial : cursosPresenciales) {
            tableModel.addRow(new Object[]{
                    cursoPresencial.getIdCurso(),
                    cursoPresencial.getNombre(),
                    cursoPresencial.getIdDocente(),
                    cursoPresencial.getDescripcion(),
                    cursoPresencial.getObjetivo(),
                    cursoPresencial.getDirigido(),
                    cursoPresencial.getPrecio(),
                    cursoPresencial.getCodigo(),
                    cursoPresencial.getIdCursoPresencial(),
                    cursoPresencial.getAula(),
                    cursoPresencial.getFecha(),
                    cursoPresencial.getHora()
            });
        }

        return tableModel;
    }

    private void agregarCursoPresencial() {
        CursoPresencial cursoPresencial = new CursoPresencial();

        cursoPresencial.setIdCurso(Integer.parseInt(view.getTextFieldIdCurso().getText()));
        cursoPresencial.setNombre(view.getTextFieldNombre().getText());
        cursoPresencial.setIdDocente(Integer.parseInt(view.getTextFieldIDDocente().getText()));
        cursoPresencial.setDescripcion(view.getTextFieldDescripcion().getText());
        cursoPresencial.setObjetivo(view.getTextFieldObjetivo().getText());
        cursoPresencial.setDirigido(view.getTextFieldDirigido().getText());
        cursoPresencial.setPrecio(Integer.parseInt(view.getTextFieldPrecio().getText()));
        cursoPresencial.setCodigo(view.getTextFieldcodigo().getText());
        cursoPresencial.setIdCursoPresencial(Integer.parseInt(view.getTextFieldIDCursoPresencial().getText()));
        cursoPresencial.setAula(Integer.parseInt(view.getTextFieldAula().getText()));
        cursoPresencial.setFecha(view.getTextFieldFecha().getText());
        cursoPresencial.setHora(view.getTextFieldHora().getText());

        cursoPresencialServiceImplementation.addCursoPresencial(cursoPresencial);
    }

    private void buscarCursoPresencial(int idCursoPresencial){
        CursoPresencial cursoPresencial = cursoPresencialServiceImplementation.getCursoPresencial(idCursoPresencial);

        view.getTextFieldIdCurso().setText(String.valueOf(cursoPresencial.getIdCurso()));
        view.getTextFieldNombre().setText(cursoPresencial.getNombre());
        view.getTextFieldIDDocente().setText(String.valueOf(cursoPresencial.getIdDocente()));
        view.getTextFieldDescripcion().setText(cursoPresencial.getDescripcion());
        view.getTextFieldObjetivo().setText(cursoPresencial.getObjetivo());
        view.getTextFieldDirigido().setText(cursoPresencial.getDirigido());
        view.getTextFieldPrecio().setText(String.valueOf(cursoPresencial.getPrecio()));
        view.getTextFieldcodigo().setText(cursoPresencial.getCodigo());
        view.getTextFieldIDCursoPresencial().setText(String.valueOf(cursoPresencial.getIdCursoPresencial()));
        view.getTextFieldAula().setText(String.valueOf(cursoPresencial.getAula()));
        view.getTextFieldFecha().setText(cursoPresencial.getFecha());
        view.getTextFieldHora().setText(cursoPresencial.getHora());

    }

    private void limpiarCampos() {
        view.getTextFieldIdCurso().setText("");
        view.getTextFieldNombre().setText("");
        view.getTextFieldIDDocente().setText("");
        view.getTextFieldDescripcion().setText("");
        view.getTextFieldObjetivo().setText("");
        view.getTextFieldDirigido().setText("");
        view.getTextFieldPrecio().setText("");
        view.getTextFieldcodigo().setText("");
        view.getTextFieldIDCursoPresencial().setText("");
        view.getTextFieldAula().setText("");
        view.getTextFieldFecha().setText("");
        view.getTextFieldHora().setText("");
    }

}
