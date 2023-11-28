package ppr.presentation.controller;

import ppr.data.dao.interfaces.CursoPresencialDao;
import ppr.logic.service.implementations.CursoPresencialServiceImplementation;
import ppr.model.CursoPresencial;
import ppr.presentation.view.CursoPresencialView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CursoPresencialController {

    CursoPresencialServiceImplementation cursoPresencialServiceImplementation = CursoPresencialServiceImplementation.getInstance();

    private final CursoPresencialView view;

    public CursoPresencialController(CursoPresencialView view) {
        this.view = view;
        cargarTablaCursosPresenciales();
        cargarUltimoIdCurso();
        cargarUltimoIdCursoPresencial();
        cargarUltimoCodigoDeCatedra();
        attachEventListeners();
    }

    private void attachEventListeners() {
    }

    private void cargarUltimoCodigoDeCatedra() {
        
    }

    private void cargarUltimoIdCursoPresencial() {
        
    }

    private void cargarUltimoIdCurso() {
        
    }

    private void cargarTablaCursosPresenciales() {
        List<CursoPresencial> cursosPresenciales = cursoPresencialServiceImplementation.getAllCursosPresenciales();
        DefaultTableModel tableModel = convertirAFormatoTabla(cursosPresenciales);
        view.getTableCursosPresenciales().setModel(tableModel);
    }

    private DefaultTableModel convertirAFormatoTabla(List<CursoPresencial> cursosPresenciales) {
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"ID Curso", "Nombre", "ID Docente", "Descripcion", "Objetivo", "Dirigido", "Precio", "Codigo", "Aula", "Fecha", "Hora"},
                0
        );

        tableModel.addRow(new Object[]{"ID Curso", "Nombre", "ID Docente", "Descripcion", "Objetivo", "Dirigido", "Precio", "Codigo", "Aula", "Fecha", "Hora"});

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
                    cursoPresencial.getAula(),
                    cursoPresencial.getFecha(),
                    cursoPresencial.getHora()
            });
        }

        return tableModel;
    }


}
