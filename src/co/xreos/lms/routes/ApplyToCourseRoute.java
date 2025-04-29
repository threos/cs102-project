package co.xreos.lms.routes;

import co.xreos.lms.controller.ApplyToCourseController;
import co.xreos.lms.controller.ViewAvailableCoursesController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.ApplyToCourseView;
import co.xreos.lms.view.ViewAvailableCoursesView;

public class ApplyToCourseRoute extends ViewControllerRoute<ApplyToCourseView, ApplyToCourseController> {
    public ApplyToCourseRoute(CourseLevel level) {
        super("/apply-course", ApplyToCourseView::new, (view) -> new ApplyToCourseController(view, level));
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
