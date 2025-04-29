package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.type.course.CourseLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MakeAnnouncementTopicView extends AppView {
    private JTextField announcementTopicField;
    private JButton continueButton;
    public MakeAnnouncementTopicView() {
        super("Enter announcement topic");
    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(2, 1, 10, 8));
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        announcementTopicField = new JTextField();
        continueButton = new JButton("Continue");

        add(announcementTopicField);
        add(continueButton);
    }

    @Override
    public void deactivate() {

    }

    public JTextField getAnnouncementTopicField() {
        return announcementTopicField;
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}
