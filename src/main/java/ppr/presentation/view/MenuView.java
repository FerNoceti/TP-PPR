package ppr.presentation.view;

import javax.swing.*;

public class MenuView {
    private JButton ventanaAlumnosButton;
    private JButton ventanaDocentesButton;
    private JButton ventanaCursosPresencialesButton;
    private JButton ventanaCursosOnlineButton;
    private JButton consultasCumpleButton;
    private JPanel menuPanel;
    private JButton inscribirCursoPresencialButton;

    public MenuView() {
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JButton getVentanaAlumnosButton() {
        return ventanaAlumnosButton;
    }

    public void setVentanaAlumnosButton(JButton ventanaAlumnosButton) {
        this.ventanaAlumnosButton = ventanaAlumnosButton;
    }

    public JButton getVentanaDocentesButton() {
        return ventanaDocentesButton;
    }

    public void setVentanaDocentesButton(JButton ventanaDocentesButton) {
        this.ventanaDocentesButton = ventanaDocentesButton;
    }

    public JButton getVentanaCursosPresencialesButton() {
        return ventanaCursosPresencialesButton;
    }

    public void setVentanaCursosPresencialesButton(JButton ventanaCursosPresencialesButton) {
        this.ventanaCursosPresencialesButton = ventanaCursosPresencialesButton;
    }

    public JButton getVentanaCursosOnlineButton() {
        return ventanaCursosOnlineButton;
    }

    public void setVentanaCursosOnlineButton(JButton ventanaCursosOnlineButton) {
        this.ventanaCursosOnlineButton = ventanaCursosOnlineButton;
    }

    public JButton getConsultasButton() {
        return consultasCumpleButton;
    }

    public void setConsultasButton(JButton consultasButton) {
        this.consultasCumpleButton = consultasButton;
    }

    public void setVisible(boolean b) {
    }

    public JButton getInscribirCursoPresencialButton() {
        return inscribirCursoPresencialButton;
    }
}
