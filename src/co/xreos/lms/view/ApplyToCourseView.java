package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.type.course.Course;

import javax.swing.*;
import java.awt.*;

public class ApplyToCourseView extends AppView {
    private JList<Course> courseList;
    private JButton applyButton;

    public ApplyToCourseView() {
        super("Apply to a course");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        courseList = new JList<>();
        applyButton = new JButton("Apply");

        add(courseList);
        add(applyButton);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void activate() {
        super.activate();
    }

    public JList<Course> getCourseList() {
        return courseList;
    }

    public JButton getApplyButton() {
        return applyButton;
    }
}
