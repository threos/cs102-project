package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;

import javax.swing.*;
import java.awt.*;

public class ExamResultView extends AppView {
    private JList<String> list;
    private JButton closeButton;

    public ExamResultView() {
        super("Taken Courses");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        list = new JList<>();
        closeButton = new JButton("Close");

        add(list);
        add(closeButton);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void activate() {
        super.activate();
    }

    public JList<String> getList() {
        return list;
    }

    public JButton getCloseButton() {
        return closeButton;
    }
}
