package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.TeacherView;

import javax.swing.*;

public class CreateCourseController extends AppController<CreateCourseView> {
    public CreateCourseController(CreateCourseView view) {
        super(view);
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getCreateButton().addActionListener(e -> {
            createCourse(view.getCourseNameField().getText(), view.getCourseCapacityField().getText(), (CourseLevel) view.getCourseLevelComboBox().getSelectedItem());
        });
    }

    private void createCourse(String courseName, String courseCapacity, CourseLevel courseLevel) {
        if(courseName.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a course name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(courseCapacity.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a course capacity.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int capacity = Integer.parseInt(courseCapacity);
            if(capacity <= 0) {
                JOptionPane.showMessageDialog(view, "Course capacity must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Course course = new Course(courseName, capacity, AuthState.getInstance().getCurrentUser().getName(), courseLevel);
            CourseRepository.getInstance().add(course);

            JOptionPane.showMessageDialog(view, "Course created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            Navigator.getInstance().pop();
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Course capacity must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onDestroy() {}
}