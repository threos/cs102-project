package co.xreos.lms.routes;

import co.xreos.lms.controller.CreateCourseController;
import co.xreos.lms.controller.ParticipantsController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.ParticipantsView;

public class ParticipantsRoute extends ViewControllerRoute<ParticipantsView, ParticipantsController> {
    public ParticipantsRoute(Course course) {
        super("/participants", () -> new ParticipantsView(course), ParticipantsController::new);
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
