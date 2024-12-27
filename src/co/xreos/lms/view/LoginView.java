package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;

import javax.swing.*;
import java.awt.*;

public class LoginView extends AppView {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        super("Log in");
    }

    @Override
    public void activate() {
        setVisible(true);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(5, 1));
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Log in");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
