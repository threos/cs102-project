package co.xreos.lms.routes;

import co.xreos.lms.controller.ApproveCourseRequestController;
import co.xreos.lms.controller.ChooseCourseController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.ApproveCourseRequestView;
import co.xreos.lms.view.ChooseCourseView;

public class ChooseCourseRoute extends ViewControllerRoute<ChooseCourseView, ChooseCourseController> {
    public ChooseCourseRoute(ChooseCourseController.CourseCallback callback) {
        super("/choose-course-route", ChooseCourseView::new, (view) -> new ChooseCourseController(view, callback));
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
