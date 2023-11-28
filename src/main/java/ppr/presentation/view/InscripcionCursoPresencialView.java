package ppr.presentation.view;

import javax.swing.*;
import java.awt.*;

public class InscripcionCursoPresencialView {
    private JTextField textFieldIDAlumno;
    private JTextField textFieldIDCurso;
    private JButton inscribirButton;
    private JPanel inscripcionCursoPresencialPanel;

    public Container getInscripcionCursoPresencialPanel() {
        return inscripcionCursoPresencialPanel;
    }

    public JButton getInscribirButton() {
        return inscribirButton;
    }

    public JTextField getTextFieldIDAlumno() {
        return textFieldIDAlumno;
    }

    public JTextField getTextFieldIDCurso() {
        return textFieldIDCurso;
    }
}
