package ppr.main;

import ppr.presentation.controller.MenuController;
import ppr.presentation.view.MenuView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuView menuView = new MenuView();
            MenuController menuController = new MenuController(menuView);

            JFrame frame = new JFrame("Menu");
            frame.setContentPane(menuView.getMenuPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}