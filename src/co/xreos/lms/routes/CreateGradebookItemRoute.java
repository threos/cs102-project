package co.xreos.lms.routes;

import co.xreos.lms.controller.CreateGradebookItemController;
import co.xreos.lms.controller.DeleteCourseController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.CreateGradebookItemView;
import co.xreos.lms.view.DeleteCourseView;

public class CreateGradebookItemRoute extends ViewControllerRoute<CreateGradebookItemView, CreateGradebookItemController> {
    public CreateGradebookItemRoute() {
        super("/create-gradebook-item", CreateGradebookItemView::new, CreateGradebookItemController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
