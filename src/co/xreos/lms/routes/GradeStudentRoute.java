package co.xreos.lms.routes;

import co.xreos.lms.controller.DeleteCourseController;
import co.xreos.lms.controller.GradeStudentController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.view.DeleteCourseView;
import co.xreos.lms.view.GradeStudentView;

public class GradeStudentRoute extends ViewControllerRoute<GradeStudentView, GradeStudentController> {
    public GradeStudentRoute(Course course) {
        super("/grade-course", () -> new GradeStudentView(course), GradeStudentController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
