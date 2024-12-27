package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.user.Teacher;
import co.xreos.lms.type.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class TeacherView extends AppView {
    private JButton createCourseButton;
    private JButton deleteCourseButton;
    private JButton approveCourseRequestButton;

    private JButton createGradebookItemButton;
    private JButton gradeStudentsButton;
    private JButton makeAnnouncementButton;
    private JButton viewCourseParticipantsButton;
    private JButton logoutButton;

    public TeacherView() {
        super("Teacher Dashboard");
    }

    @Override
    public void activate() {
        setVisible(true);
        setTitle("Teacher Dashboard - " + AuthState.getInstance().getCurrentUser().getName());
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onCreate() {
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        User user = AuthState.getInstance().getCurrentUser();

        ArrayList<JButton> buttons = new ArrayList<>(createCourseButton, deleteCourseButton, approveCourseRequestButton, createGradebookItemButton, gradeStudentsButton, makeAnnouncementButton, viewCourseParticipantsButton);

        setLayout(new GridLayout(buttons.size(), 1, 10, 16));

        for (JButton button : buttons) {
            add(button);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public JButton getCreateGradebookItemButton() {
        return this.createGradebookItemButton;
    }

    public JButton getCreateCourseButton() {
        return this.createCourseButton;
    }

    public JButton getDeleteCourseButton() {
        return this.deleteCourseButton;
    }

    public JButton getApproveCourseRequestButton() {
        return this.approveCourseRequestButton;
    }

    public JButton getGradeStudentsButton() {
        return this.gradeStudentsButton;
    }

    public JButton getMakeAnnouncementButton() {
        return this.makeAnnouncementButton;
    }

    public JButton getViewCourseParticipantsButton() {
        return this.viewCourseParticipantsButton;
    }

    public JButton getLogoutButton() {
        return this.logoutButton;
    }
}
