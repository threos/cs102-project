package co.xreos.lms.routes;

import co.xreos.lms.controller.ExamResultController;
import co.xreos.lms.controller.StudentController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.view.ExamResultView;
import co.xreos.lms.view.StudentView;

public class ExamResultRoute extends ViewControllerRoute<ExamResultView, ExamResultController> {
    public ExamResultRoute(Course course) {
        super("/exam-result", ExamResultView::new, (view) -> new ExamResultController(view, course));
    }
}
