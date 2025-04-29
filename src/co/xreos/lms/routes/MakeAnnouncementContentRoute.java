package co.xreos.lms.routes;

import co.xreos.lms.controller.MakeAnnouncementContentController;
import co.xreos.lms.controller.MakeAnnouncementTopicController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.view.MakeAnnouncementContentView;
import co.xreos.lms.view.MakeAnnouncementTopicView;

public class MakeAnnouncementContentRoute extends ViewControllerRoute<MakeAnnouncementContentView, MakeAnnouncementContentController> {
    public MakeAnnouncementContentRoute(Course course, String topic) {
        super("/make-announcement-content", MakeAnnouncementContentView::new, (view) -> new MakeAnnouncementContentController(view, course, topic));
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
