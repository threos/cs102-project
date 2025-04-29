package co.xreos.lms.routes;

import co.xreos.lms.controller.CreateCourseController;
import co.xreos.lms.controller.LoginController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.LoginView;

public class CreateCourseRoute extends ViewControllerRoute<CreateCourseView, CreateCourseController> {
    public CreateCourseRoute() {
        super("/create-course", CreateCourseView::new, CreateCourseController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
