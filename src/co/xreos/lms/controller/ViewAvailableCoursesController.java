package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.DeleteCourseView;
import co.xreos.lms.view.ViewAvailableCoursesView;

import javax.swing.*;

public class ViewAvailableCoursesController extends AppController<ViewAvailableCoursesView> {
    private final CourseLevel level;

    public ViewAvailableCoursesController(ViewAvailableCoursesView view, CourseLevel level) {
        super(view);
        this.level = level;
    }

    @Override
    public void activate() {
        view.getCourseList().setListData(CourseRepository.getInstance().getAll().stream().filter(course -> ((Course) course).getLevel().equals(level)).toArray(Course[]::new));

        if(view.getCourseList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No courses to view.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getCloseButton().addActionListener(e -> {
            Navigator.getInstance().pop();
        });
    }

    @Override
    public void onDestroy() {}
}