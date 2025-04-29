package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.DeleteCourseView;

import javax.swing.*;

public class DeleteCourseController extends AppController<DeleteCourseView> {
    public DeleteCourseController(DeleteCourseView view) {
        super(view);
    }

    @Override
    public void activate() {
        if(view.getCourseList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No courses to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getDeleteButton().addActionListener(e -> {
            deleteCourse(view.getCourseList().getSelectedValue());
        });
    }

    private void deleteCourse(Course course) {
        if(course == null) {
            JOptionPane.showMessageDialog(view, "Please select a course to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        CourseRepository.getInstance().delete(course);
        JOptionPane.showMessageDialog(view, "Course deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        Navigator.getInstance().pop();
    }

    @Override
    public void onDestroy() {}
}