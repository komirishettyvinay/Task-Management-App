package ui;

import javax.swing.*;

public class TeamLeaderUI {
    public void show() {
        JFrame frame = new JFrame("Team Leader Dashboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.add(new JLabel("Welcome to the Team Leader Dashboard!"));

        frame.setVisible(true);
    }
}
