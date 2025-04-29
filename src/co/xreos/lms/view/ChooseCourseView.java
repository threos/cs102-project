package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;

import javax.swing.*;
import java.awt.*;

public class ChooseCourseView extends AppView {
    private JList<Course> courseList;
    private JButton approveButton;

    public ChooseCourseView() {
        super("Choose a Course");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        courseList = new JList<>();
        approveButton = new JButton("Select Course");

        add(courseList);
        add(approveButton);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void activate() {
        super.activate();
        if(CourseRepository.getInstance().getAll().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No courses available.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    public JList<Course> getCourseList() {
        return courseList;
    }

    public JButton getApproveButton() {
        return approveButton;
    }
}
