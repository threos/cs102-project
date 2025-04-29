package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;

import javax.swing.*;
import java.awt.*;

public class TakenCoursesView extends AppView {
    private JList<String> enrollmentList;
    private JButton closeButton;

    public TakenCoursesView() {
        super("Taken Courses");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        enrollmentList = new JList<>();
        closeButton = new JButton("Close");

        add(enrollmentList);
        add(closeButton);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void activate() {
        super.activate();
    }

    public JList<String> getEnrollmentList() {
        return enrollmentList;
    }

    public JButton getCloseButton() {
        return closeButton;
    }
}
