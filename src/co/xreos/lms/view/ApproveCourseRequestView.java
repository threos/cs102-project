package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.StudentCourseRequestRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.type.course.StudentCourseRequest;

import javax.swing.*;
import java.awt.*;

public class ApproveCourseRequestView extends AppView {
    private JList<Object> requestList;
    private JButton approveButton;

    public ApproveCourseRequestView() {
        super("Approve Course Request");
    }

    @Override
    public void onCreate() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        requestList = new JList<>();
        approveButton = new JButton("Select Course");

        add(requestList);
        add(approveButton);
    }

    @Override
    public void deactivate() {

    }

    @Override
    public void activate() {
        super.activate();
        if(CourseRepository.getInstance().getAll().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No requests to approve.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    public JList<Object> getRequestList() {
        return requestList;
    }

    public JButton getApproveButton() {
        return approveButton;
    }
}
