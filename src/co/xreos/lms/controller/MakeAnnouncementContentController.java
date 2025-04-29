package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.repository.AnnouncementRepository;
import co.xreos.lms.type.announcement.Announcement;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.view.MakeAnnouncementContentView;
import co.xreos.lms.view.MakeAnnouncementTopicView;

import javax.swing.*;

public class MakeAnnouncementContentController extends AppController<MakeAnnouncementContentView> {
    private final Course course;
    private final String topic;

    public MakeAnnouncementContentController(MakeAnnouncementContentView view, Course course, String topic) {
        super(view);
        this.topic = topic;
        this.course = course;
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getContinueButton().addActionListener(e -> {
            proceed(view.getAnnouncementContentField().getText());
        });
    }

    private void proceed(String content) {
        if(content == null || content.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter the content.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AnnouncementRepository.getInstance().add(new Announcement(course.getName(), topic, content));

        JOptionPane.showMessageDialog(view, "Announcement created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void onDestroy() {}

    public interface TopicCallback {
        void onTopicSelected(String topic);
    }
}