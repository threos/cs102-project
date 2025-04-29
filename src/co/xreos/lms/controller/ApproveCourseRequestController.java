package co.xreos.lms.controller;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.StudentCourseEnrollmentRepository;
import co.xreos.lms.repository.StudentCourseRequestRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.course.StudentCourseRequest;
import co.xreos.lms.view.ApproveCourseRequestView;
import co.xreos.lms.view.DeleteCourseView;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApproveCourseRequestController extends AppController<ApproveCourseRequestView> {
    private String selectedCourse = null;
    public ApproveCourseRequestController(ApproveCourseRequestView view) {
        super(view);
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        Map<String, StudentCourseRequest> requestMap = new HashMap<>();
        List<SerializableSchemaModel> requests = (StudentCourseRequestRepository.getInstance().getAll());
        for(SerializableSchemaModel request : requests) {
            requestMap.put(((StudentCourseRequest) request).getCourseId(), (StudentCourseRequest) request);
        }

        DefaultListModel<Object> model = new DefaultListModel<>();
        model.addAll(requestMap.values().stream().map(StudentCourseRequest::getCourseId).toList());
        view.getRequestList().setModel(model);

        if(model.isEmpty()) {
            JOptionPane.showMessageDialog(view, "No requests to approve.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }

        view.getApproveButton().addActionListener(e -> {
            Object obj = view.getRequestList().getSelectedValue();
            if(obj instanceof String) {
                selectRequest((String) obj);
            } else if(obj instanceof StudentCourseRequest) {
                approve((StudentCourseRequest) obj);
            }
        });
    }

    private void selectRequest(String course) {
        view.getApproveButton().setText("Approve Request");
        List<SerializableSchemaModel> requests = (StudentCourseRequestRepository.getInstance().getAll());

        DefaultListModel<Object> model = new DefaultListModel<>();

        for(SerializableSchemaModel r : requests) {
            if(((StudentCourseRequest) r).getCourseId().equals(course)) {
                model.addElement(r);
            }
        }

        view.getRequestList().setModel(model);
    }

    private void approve(StudentCourseRequest request) {
        if(request == null) {
            JOptionPane.showMessageDialog(view, "Please select a request to approve.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        StudentCourseRequestRepository.getInstance().delete(request);
        StudentCourseEnrollmentRepository.getInstance().add(new StudentCourseEnrollment(request.getCourseId(), request.getStudent()));
        JOptionPane.showMessageDialog(view, "Request approved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void onDestroy() {}
}