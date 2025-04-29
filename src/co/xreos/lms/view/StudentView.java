package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentView extends AppView {

    private JButton viewAvailableCoursesButton;
    private JButton applyToCourseButton;
    private JButton viewTakenCoursesButton;
    private JButton viewExamResultsButton;
    private JButton viewTranscriptButton;
    private JButton viewAnnouncementsButton;
    private JButton logoutButton;

    public StudentView() {
        super("Student Dashboard");
    }

    @Override
    public void activate() {
        setTitle("Student Dashboard - " + AuthState.getInstance().getCurrentUser().getName());
        super.activate();
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onCreate() {
        setSize(300, 700);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        User user = AuthState.getInstance().getCurrentUser();

        ArrayList<JButton> buttons = new ArrayList<>(List.of(
                viewAvailableCoursesButton = new JButton("View Available Courses"),
                applyToCourseButton = new JButton("Apply to Course"),
                viewTakenCoursesButton = new JButton("View Taken Courses"),
                viewExamResultsButton = new JButton("View Exam Results"),
                viewTranscriptButton = new JButton("View Transcript"),
                viewAnnouncementsButton = new JButton("View Announcements"),
                logoutButton = new JButton("Logout")
        ));

        setLayout(new GridLayout(buttons.size(), 1, 10, 16));

        for (JButton button : buttons) {
            add(button);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public JButton getViewAvailableCoursesButton() {
        return this.viewAvailableCoursesButton;
    }

    public JButton getApplyToCourseButton() {
        return this.applyToCourseButton;
    }

    public JButton getViewTakenCoursesButton() {
        return this.viewTakenCoursesButton;
    }

    public JButton getViewExamResultsButton() {
        return this.viewExamResultsButton;
    }

    public JButton getViewTranscriptButton() {
        return this.viewTranscriptButton;
    }

    public JButton getViewAnnouncementsButton() {
        return this.viewAnnouncementsButton;
    }

    public JButton getLogoutButton() {
        return this.logoutButton;
    }
}
