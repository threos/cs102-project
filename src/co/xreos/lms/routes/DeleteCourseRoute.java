package co.xreos.lms.routes;

import co.xreos.lms.controller.CreateCourseController;
import co.xreos.lms.controller.DeleteCourseController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.DeleteCourseView;

public class DeleteCourseRoute extends ViewControllerRoute<DeleteCourseView, DeleteCourseController> {
    public DeleteCourseRoute() {
        super("/delete-course", DeleteCourseView::new, DeleteCourseController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
