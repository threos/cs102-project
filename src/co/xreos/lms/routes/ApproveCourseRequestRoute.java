package co.xreos.lms.routes;

import co.xreos.lms.controller.ApproveCourseRequestController;
import co.xreos.lms.controller.CreateCourseController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.ApproveCourseRequestView;
import co.xreos.lms.view.CreateCourseView;

public class ApproveCourseRequestRoute extends ViewControllerRoute<ApproveCourseRequestView, ApproveCourseRequestController> {
    public ApproveCourseRequestRoute() {
        super("/approve-course-request", ApproveCourseRequestView::new, ApproveCourseRequestController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
