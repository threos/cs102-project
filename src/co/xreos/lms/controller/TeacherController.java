package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.user.Teacher;
import co.xreos.lms.type.user.User;
import co.xreos.lms.view.LoginView;
import co.xreos.lms.view.TeacherView;

import javax.swing.*;

public class TeacherController extends AppController<TeacherView> {
    public TeacherController(TeacherView view) {
        super(view);
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {}
}