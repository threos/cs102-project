package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.type.course.CourseLevel;

import javax.swing.*;
import java.awt.*;

public class CreateCourseView extends AppView {
    private TextField courseNameField;
    private TextField courseCapacityField;
    private JComboBox<CourseLevel> courseLevelComboBox;
    private JButton createButton;

    public CreateCourseView() {
        super("Create Course");
    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(4, 2, 10, 8));
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        courseNameField = new TextField();
        courseCapacityField = new TextField();
        courseLevelComboBox = new JComboBox<>(CourseLevel.values());
        createButton = new JButton("Create Course");

        add(new JLabel("Course Name:"));
        add(courseNameField);
        add(new JLabel("Course Capacity:"));
        add(courseCapacityField);
        add(new JLabel("Course Level:"));
        add(courseLevelComboBox);
        add(new Container());
        add(createButton);
    }

    @Override
    public void deactivate() {

    }

    public JComboBox<CourseLevel> getCourseLevelComboBox() {
        return courseLevelComboBox;
    }

    public TextField getCourseNameField() {
        return courseNameField;
    }

    public TextField getCourseCapacityField() {
        return courseCapacityField;
    }

    public JButton getCreateButton() {
        return createButton;
    }
}
