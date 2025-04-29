package co.xreos.lms.routes;

import co.xreos.lms.controller.CreateGradebookItemController;
import co.xreos.lms.controller.MakeAnnouncementTopicController;
import co.xreos.lms.navigation.route.impl.ViewControllerRoute;
import co.xreos.lms.view.CreateGradebookItemView;
import co.xreos.lms.view.MakeAnnouncementTopicView;

public class MakeAnnouncementTopicRoute extends ViewControllerRoute<MakeAnnouncementTopicView, MakeAnnouncementTopicController> {
    public MakeAnnouncementTopicRoute(MakeAnnouncementTopicController.TopicCallback callback) {
        super("/make-announcement-topic", MakeAnnouncementTopicView::new, (view) -> new MakeAnnouncementTopicController(view, callback));
    }

    @Override
    public boolean isTransient() {
        return true;
    }
}
