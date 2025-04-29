package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.routes.*;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.StudentView;
import co.xreos.lms.view.TeacherView;

public class StudentController extends AppController<StudentView> {
    public StudentController(StudentView view) {
        super(view);
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getViewAvailableCoursesButton().addActionListener(e -> {
            Navigator.getInstance().push(new ViewAvailableCoursesRoute(CourseLevel.UNDERGRADUATE));
        });
        view.getApplyToCourseButton().addActionListener(e -> {
            Navigator.getInstance().push(new ApplyToCourseRoute(CourseLevel.UNDERGRADUATE));
        });
        view.getViewTakenCoursesButton().addActionListener(e -> {
            Navigator.getInstance().push(new TakenCoursesRoute());
        });
        view.getViewExamResultsButton().addActionListener(e -> {
            Navigator.getInstance().push(new ChooseCourseRoute(course -> {
                Navigator.getInstance().push(new ExamResultRoute(course));
            }));
        });
    }

    @Override
    public void onDestroy() {}
}