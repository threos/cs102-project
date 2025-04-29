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
        setTitle("Teacher Dashboard - " + AuthState.getInstance().getCurrentUser().getName());
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
                createCourseButton = new JButton("Create Course"),
                deleteCourseButton = new JButton("Delete Course"),
                approveCourseRequestButton = new JButton("Approve Course Request"),
                createGradebookItemButton = new JButton("Create Gradebook Item"),
                gradeStudentsButton = new JButton("Grade Students"),
                makeAnnouncementButton = new JButton("Make Announcement"),
                viewCourseParticipantsButton = new JButton("View Course Participants"),
                logoutButton = new JButton("Log out")
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
