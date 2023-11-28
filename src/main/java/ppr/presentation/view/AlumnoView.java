package ppr.presentation.view;

import javax.swing.*;

public class AlumnoView {
    private JPanel alumnoPanel;
    private JLabel title;
    private JTextField textFieldIDSearch;
    private JLabel labelID;
    private JButton buttonSearchID;
    private JLabel labelDNI;
    private JTextField textFieldDNI;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldFechaNac;
    private JTextField textFieldEdad;
    private JTextField textFieldIdAlumno;
    private JTextField textFieldLegajo;
    private JButton buttonClear;
    private JButton buttonGetAllAlumnos;
    private JTable tablealumnos;
    private JButton buttonAddAlumno;
    private JTextField textFieldId;

    public AlumnoView() {
    }

    public JPanel getAlumnoPanel() {
        return alumnoPanel;
    }

    public JTextField getTextFieldIDSearch() {
        return textFieldIDSearch;
    }

    public JButton getButtonSearch() {
        return buttonSearchID;
    }

    public JTextField getTextFieldDNI() {
        return textFieldDNI;
    }

    public JTextField getTextFieldNombre() {
        return textFieldNombre;
    }

    public JTextField getTextFieldApellido() {
        return textFieldApellido;
    }

    public JTextField getTextFieldFechaNac() {
        return textFieldFechaNac;
    }

    public JTextField getTextFieldEdad() {
        return textFieldEdad;
    }

    public JTextField getTextFieldIdAlumno() {
        return textFieldIdAlumno;
    }

    public JTextField getTextFieldLegajo() {
        return textFieldLegajo;
    }

    public JButton getButtonClear() {
        return buttonClear;
    }

    public JButton getButtonGetAllAlumnos() {
        return buttonGetAllAlumnos;
    }

    public JTable getTableAlumnos() {
        return tablealumnos;
    }

    public JButton getButtonAddAlumno() {
        return buttonAddAlumno;
    }

    public JTextField getTextFieldId() {
        return textFieldId;
    }

    public void setVisible(boolean b) {
    }
}
