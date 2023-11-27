package ppr.presentation.view;

import javax.swing.*;

public class DocenteView {
    private JPanel docentePanel;
    private JLabel title;
    private JTextField textFieldIdSearch;
    private JTextField textFieldApellido;
    private JTextField textFieldIdPersona;
    private JTextField textFieldFechaNacimiento;
    private JTextField textFieldNombre;
    private JTextField textFieldEdad;
    private JTextField textFieldIdDocente;
    private JTextField textFieldCV;
    private JButton buttonSearch;
    private JTextField textFieldDNI;
    private JButton agregarDocenteButton;
    private JButton buttonClear;
    private JButton buttonBuscarTodos;
    private JTable tableDocentes;

    public DocenteView() {
    }

    public JPanel getDocentePanel() {
        return docentePanel;
    }

    public void setDocentePanel(JPanel docentePanel) {
        this.docentePanel = docentePanel;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JTextField getTextFieldIdSearch() {
        return textFieldIdSearch;
    }

    public void setTextFieldIdSearch(JTextField textFieldIdSearch) {
        this.textFieldIdSearch = textFieldIdSearch;
    }

    public JTextField getTextFieldApellido() {
        return textFieldApellido;
    }

    public void setTextFieldApellido(JTextField textFieldApellido) {
        this.textFieldApellido = textFieldApellido;
    }

    public JTextField getTextFieldIdPersona() {
        return textFieldIdPersona;
    }

    public void setTextFieldIdPersona(JTextField textFieldIdPersona) {
        this.textFieldIdPersona = textFieldIdPersona;
    }

    public JTextField getTextFieldFechaNacimiento() {
        return textFieldFechaNacimiento;
    }

    public void setTextFieldFechaNacimiento(JTextField textFieldFechaNacimiento) {
        this.textFieldFechaNacimiento = textFieldFechaNacimiento;
    }

    public JTextField getTextFieldNombre() {
        return textFieldNombre;
    }

    public void setTextFieldNombre(JTextField textFieldNombre) {
        this.textFieldNombre = textFieldNombre;
    }

    public JTextField getTextFieldEdad() {
        return textFieldEdad;
    }

    public void setTextFieldEdad(JTextField textFieldEdad) {
        this.textFieldEdad = textFieldEdad;
    }

    public JTextField getTextFieldIdDocente() {
        return textFieldIdDocente;
    }

    public void setTextFieldIdDocente(JTextField textFieldIdDocente) {
        this.textFieldIdDocente = textFieldIdDocente;
    }

    public JTextField getTextFieldCV() {
        return textFieldCV;
    }

    public void setTextFieldCV(JTextField textFieldCV) {
        this.textFieldCV = textFieldCV;
    }

    public JButton getButton1() {
        return buttonSearch;
    }

    public void setButton1(JButton button1) {
        this.buttonSearch = button1;
    }

    public JTextField getTextFieldDNI() {
        return textFieldDNI;
    }

    public void setTextFieldDNI(JTextField textFieldDNI) {
        this.textFieldDNI = textFieldDNI;
    }

    public JButton getAgregarDocenteButton() {
        return agregarDocenteButton;
    }

    public void setAgregarDocenteButton(JButton agregarDocenteButton) {
        this.agregarDocenteButton = agregarDocenteButton;
    }

    public JButton getButtonClear() {
        return buttonClear;
    }

    public void setButtonClear(JButton buttonClear) {
        this.buttonClear = buttonClear;
    }

    public JButton getButtonBuscarTodos() {
        return buttonBuscarTodos;
    }

    public void setButtonBuscarTodos(JButton buttonBuscarTodos) {
        this.buttonBuscarTodos = buttonBuscarTodos;
    }

    public JTable getTableDocentes() {
        return tableDocentes;
    }

    public void setTableDocentes(JTable tableDocentes) {
        this.tableDocentes = tableDocentes;
    }

    public JButton getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(JButton buttonSearch) {
        this.buttonSearch = buttonSearch;
    }

    public JButton getAgregarDocente() {
        return agregarDocenteButton;
    }

    public void setAgregarDocente(JButton agregarDocente) {
        this.agregarDocenteButton = agregarDocente;
    }
}
