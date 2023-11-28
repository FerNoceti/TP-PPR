package ppr.presentation.controller;

import ppr.logic.service.implementations.AlumnosPorCursoServiceImp;
import ppr.logic.service.interfaces.AlumnosPorCursoService;
import ppr.presentation.view.InscripcionCursoPresencialView;

import javax.swing.*;

public class InscribirCursoPresencialController {
    AlumnosPorCursoService alumnosPorCursoService = AlumnosPorCursoServiceImp.getInstance();
    private final InscripcionCursoPresencialView view;

    public InscribirCursoPresencialController(InscripcionCursoPresencialView view) {
        this.view = view;
        attachEvents();
    }

    private void attachEvents() {
        view.getInscribirButton().addActionListener(e -> {
            int idAlumno = Integer.parseInt(view.getTextFieldIDAlumno().getText());
            int idCurso = Integer.parseInt(view.getTextFieldIDCurso().getText());

            if (idAlumno < 0 || idCurso < 0) {
                JOptionPane.showMessageDialog(null, "Los IDs deben ser positivos");
                return;
            } else if (alumnosPorCursoService.existeAlumnoEnCurso(idAlumno, idCurso)) {
                JOptionPane.showMessageDialog(null, "El alumno ya está inscripto en el curso");
            } else if (alumnosPorCursoService.getNumAlumnosEnCurso(idCurso) >= 15) {
                JOptionPane.showMessageDialog(null, "El curso está lleno");
            } else {
                boolean agregado = alumnosPorCursoService.addAlumnoACursoPresencial(idAlumno, idCurso);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Alumno agregado al curso");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar al alumno al curso");
                }
            }
        });
    }
}