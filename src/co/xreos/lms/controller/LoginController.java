package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.user.*;
import co.xreos.lms.view.LoginView;

import javax.swing.*;

public class LoginController extends AppController<LoginView> {
    public LoginController(LoginView view) {
        super(view);
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getLoginButton().addActionListener(e -> {
            System.out.println("Login button clicked");
            String username = view.getUsernameField().getText();
            String password = new String(view.getPasswordField().getPassword());
            if(!validate(username, password)) return;
            login(username, password, (Role) view.getRoleComboBox().getSelectedItem());
        });
    }

    @Override
    public void onDestroy() {}

    public boolean validate(String username, String password) {
        if(username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Username and password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void login(String username, String password, Role role) {
        User user = AuthState.getInstance().login(username, password, role);
        if(user == null) {
            JOptionPane.showMessageDialog(view, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(user instanceof Teacher) {
            Navigator.getInstance().popAndPushNamed("/teacher");
        } else if (user instanceof TA) {

        } else if (user instanceof Student) {
            Navigator.getInstance().popAndPushNamed("/student");
        }
    }
}