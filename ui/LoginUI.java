package ui;

import models.User;
import services.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 110, 300, 25);
        panel.add(resultLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                UserService userService = new UserService();
                User user = userService.authenticate(username, password);

                if (user != null) {
                    resultLabel.setText("Login successful! Role: " + user.getRole());
                    
                    // Open role-specific UI
                    switch (user.getRole()) {
                        case "Admin":
                            new AdminUI().show(); // Create this class for Admin functionalities.
                            break;
                        case "Team Leader":
                            new TeamLeaderUI().show(); // Create this class for Team Leader functionalities.
                            break;
                        case "Team Member":
                            new TeamMemberUI().show(); // Create this class for Team Member functionalities.
                            break;
                        default:
                            resultLabel.setText("Unknown role. Contact administrator.");
                    }
                } else {
                    resultLabel.setText("Invalid credentials.");
                }
            }
        });
    }
}
