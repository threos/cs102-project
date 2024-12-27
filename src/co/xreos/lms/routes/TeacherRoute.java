package co.xreos.lms.routes;

import co.xreos.lms.controller.LoginController;
import co.xreos.lms.controller.TeacherController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.LoginView;
import co.xreos.lms.view.TeacherView;

public class TeacherRoute extends ViewControllerRoute<TeacherView, TeacherController> {
    public TeacherRoute() {
        super("/teacher", new TeacherView(), TeacherController::new);
    }
}
