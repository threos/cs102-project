package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DeleteCourseView extends AppView {
    private JList<Course> courseList;
    private JButton deleteButton;

    public DeleteCourseView() {
        super("Delete Course");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        courseList = new JList<>(CourseRepository.getInstance().getAll().toArray(new Course[0]));
        deleteButton = new JButton("Delete Course");

        add(courseList);
        add(deleteButton);
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

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
