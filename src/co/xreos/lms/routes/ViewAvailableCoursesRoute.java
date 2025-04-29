package co.xreos.lms.routes;

import co.xreos.lms.controller.DeleteCourseController;
import co.xreos.lms.controller.ViewAvailableCoursesController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.DeleteCourseView;
import co.xreos.lms.view.ViewAvailableCoursesView;

public class ViewAvailableCoursesRoute extends ViewControllerRoute<ViewAvailableCoursesView, ViewAvailableCoursesController> {
    public ViewAvailableCoursesRoute(CourseLevel level) {
        super("/view-courses", ViewAvailableCoursesView::new, (view) -> new ViewAvailableCoursesController(view, level));
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
