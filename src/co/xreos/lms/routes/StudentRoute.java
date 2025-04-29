package co.xreos.lms.routes;

import co.xreos.lms.controller.StudentController;
import co.xreos.lms.controller.TeacherController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.StudentView;
import co.xreos.lms.view.TeacherView;

public class StudentRoute extends ViewControllerRoute<StudentView, StudentController> {
    public StudentRoute() {
        super("/student", StudentView::new, StudentController::new);
    }
}
