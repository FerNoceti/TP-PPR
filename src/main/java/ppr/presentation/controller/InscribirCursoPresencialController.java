package ppr.presentation.controller;

import ppr.presentation.view.InscripcionCursoPresencialView;
import ppr.service.implementations.AlumnosPorCursoServiceImp;
import ppr.service.interfaces.AlumnosPorCursoService;

import javax.swing.*;

public class InscribirCursoPresencialController {
    private final InscripcionCursoPresencialView view;
    AlumnosPorCursoService alumnosPorCursoService = AlumnosPorCursoServiceImp.getInstance();

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
            } else if (alumnosPorCursoService.existeAlumnoEnCurso(idAlumno, idCurso)) {
                JOptionPane.showMessageDialog(null, "El alumno ya está inscripto en el curso");
            } else if (alumnosPorCursoService.getNumAlumnosEnCurso(idCurso) >= 15) {
                JOptionPane.showMessageDialog(null, "El curso está lleno");
            } else {
                boolean agregado = alumnosPorCursoService.addAlumnoACursoPresencial(idAlumno, idCurso);

                int descuento = alumnosPorCursoService.descuentoPorCantidadDeCursos(idCurso);
                System.out.printf("Descuento: %d\n", descuento);

                if (agregado) {
                    JOptionPane.showMessageDialog(null, "Alumno agregado al curso");
                    if (descuento > 0) {
                        JOptionPane.showMessageDialog(null, "El alumno tiene un descuento del " + descuento + "% en su próxima inscripción");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar al alumno al curso");
                }
            }
        });
    }
}