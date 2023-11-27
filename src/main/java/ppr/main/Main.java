package ppr.main;

import ppr.logic.service.implementations.AlumnoServiceImp;
import ppr.model.Alumno;
import ppr.presentation.controller.AlumnoController;
import ppr.presentation.view.AlumnoView;

import javax.swing.*;

import java.sql.Timestamp;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {


        /*
        AlumnoServiceImp alumnoServiceImp = AlumnoServiceImp.getInstance();

        Alumno alumno = new Alumno();

        alumno.setIdPersona(20);
        alumno.setDni(12345678);
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setFechaNacimiento(new Timestamp(2000, 1, 1, 0, 0, 0, 0));
        alumno.setIdAlumno(20);

        alumnoServiceImp.addAlumno(alumno);

        */

        /*
        SwingUtilities.invokeLater(() -> {
            AlumnoView alumnoView = new AlumnoView();
            new AlumnoController(alumnoView);

            JFrame frame = new JFrame("Alumno View");
            frame.setContentPane(alumnoView.getAlumnoPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });

         */
    }
}