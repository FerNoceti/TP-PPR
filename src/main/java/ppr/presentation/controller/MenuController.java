package ppr.presentation.controller;

import ppr.presentation.view.*;

import javax.swing.*;

public class MenuController {
    private final MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        attachEventListeners();
    }

    private void attachEventListeners() {
        view.getVentanaAlumnosButton().addActionListener(e -> {
            AlumnoView alumnoView = new AlumnoView();
            AlumnoController alumnoController = new AlumnoController(alumnoView);

            JFrame frame = new JFrame("Alumnos");
            frame.setContentPane(alumnoView.getAlumnoPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });

        view.getVentanaDocentesButton().addActionListener(e -> {
            DocenteView docenteView = new DocenteView();
            DocenteController docenteController = new DocenteController(docenteView);

            JFrame frame = new JFrame("Docentes");
            frame.setContentPane(docenteView.getDocentePanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });

        view.getVentanaCursosPresencialesButton().addActionListener(e -> {
            CursoPresencialView cursoPresencialView = new CursoPresencialView();
            CursoPresencialController cursoPresencialController = new CursoPresencialController(cursoPresencialView);

            JFrame frame = new JFrame("Cursos Presenciales");
            frame.setContentPane(cursoPresencialView.getCursoPresencialPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });

        view.getInscribirCursoPresencialButton().addActionListener(e -> {
            InscripcionCursoPresencialView inscribirCursoPresencialView = new InscripcionCursoPresencialView();
            InscribirCursoPresencialController inscribirCursoPresencialController = new InscribirCursoPresencialController(inscribirCursoPresencialView);

            JFrame frame = new JFrame("Inscribir Curso Presencial");
            frame.setContentPane(inscribirCursoPresencialView.getInscripcionCursoPresencialPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });

        view.getVentanaCursosOnlineButton().addActionListener(e -> {
            CursoVirtualView cursoVirtualView = new CursoVirtualView();
            CursoVirtualController cursoVirtualController = new CursoVirtualController(cursoVirtualView);

            JFrame frame = new JFrame("Curso Virtual");
            frame.setContentPane(cursoVirtualView.getCursoVirtualPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
