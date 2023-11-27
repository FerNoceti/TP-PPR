package ppr.presentation.controller;

import ppr.presentation.view.AlumnoView;
import ppr.presentation.view.MenuView;

import javax.swing.*;

public class MenuController {
    private MenuView view;

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
    }
}
