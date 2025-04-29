package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.MakeAnnouncementTopicView;

import javax.swing.*;

public class MakeAnnouncementTopicController extends AppController<MakeAnnouncementTopicView> {
    private final TopicCallback callback;

    public MakeAnnouncementTopicController(MakeAnnouncementTopicView view, TopicCallback callback) {
        super(view);
        this.callback = callback;
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getContinueButton().addActionListener(e -> {
            proceed(view.getAnnouncementTopicField().getText());
        });
    }

    private void proceed(String topic) {
        if(topic == null || topic.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a topic.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        callback.onTopicSelected(topic);
    }

    @Override
    public void onDestroy() {}

    public interface TopicCallback {
        void onTopicSelected(String topic);
    }
}