package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;

import javax.swing.*;
import java.awt.*;

public class ViewAvailableCoursesView extends AppView {
    private JList<Course> courseList;
    private JButton closeButton;

    public ViewAvailableCoursesView() {
        super("Available Courses");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        courseList = new JList<>();
        closeButton = new JButton("Close");

        add(courseList);
        add(closeButton);
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

    public JButton getCloseButton() {
        return closeButton;
    }
}
