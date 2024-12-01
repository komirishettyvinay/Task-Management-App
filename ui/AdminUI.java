package ui;

import javax.swing.*;

public class AdminUI {
    public void show() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.add(new JLabel("Welcome to the Admin Dashboard!"));

        frame.setVisible(true);
    }
}
