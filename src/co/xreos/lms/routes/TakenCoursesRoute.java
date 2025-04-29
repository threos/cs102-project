package co.xreos.lms.routes;

import co.xreos.lms.controller.ParticipantsController;
import co.xreos.lms.controller.TakenCoursesController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.view.ParticipantsView;
import co.xreos.lms.view.TakenCoursesView;

public class TakenCoursesRoute extends ViewControllerRoute<TakenCoursesView, TakenCoursesController> {
    public TakenCoursesRoute() {
        super("/taken-courses", TakenCoursesView::new, TakenCoursesController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
