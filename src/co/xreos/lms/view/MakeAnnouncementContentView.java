package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;

import javax.swing.*;
import java.awt.*;

public class MakeAnnouncementContentView extends AppView {
    private JTextField announcementContentField;
    private JButton continueButton;
    public MakeAnnouncementContentView() {
        super("Enter announcement content");
    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(2, 1, 10, 8));
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        announcementContentField = new JTextField();
        continueButton = new JButton("Continue");

        add(announcementContentField);
        add(continueButton);
    }

    @Override
    public void deactivate() {

    }

    public JTextField getAnnouncementContentField() {
        return announcementContentField;
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}
