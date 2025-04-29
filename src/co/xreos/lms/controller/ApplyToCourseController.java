package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.StudentCourseRequestRepository;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.type.course.StudentCourseRequest;
import co.xreos.lms.view.ApplyToCourseView;
import co.xreos.lms.view.ViewAvailableCoursesView;

import javax.swing.*;

public class ApplyToCourseController extends AppController<ApplyToCourseView> {
    private final CourseLevel level;

    public ApplyToCourseController(ApplyToCourseView view, CourseLevel level) {
        super(view);
        this.level = level;
    }

    @Override
    public void activate() {
        view.getCourseList().setListData(CourseRepository.getInstance().getAll().stream().filter(course -> ((Course) course).getLevel().equals(level)).toArray(Course[]::new));

        if(view.getCourseList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No courses to apply to.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getApplyButton().addActionListener(e -> {
            apply(view.getCourseList().getSelectedValue());
        });
    }

    private void apply(Course course) {
        if(course == null) {
            JOptionPane.showMessageDialog(view, "Please select a course to apply to.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StudentCourseRequest request = new StudentCourseRequest(course.getName(), AuthState.getInstance().getCurrentUser().getName());

        StudentCourseRequestRepository.getInstance().add(request);

        JOptionPane.showMessageDialog(view, "Successfully applied to course.", "Success", JOptionPane.INFORMATION_MESSAGE);
        Navigator.getInstance().pop();
    }

    @Override
    public void onDestroy() {}
}