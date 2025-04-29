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
import co.xreos.lms.view.ChooseCourseView;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseCourseController extends AppController<ChooseCourseView> {
    private final CourseCallback callback;
    public ChooseCourseController(ChooseCourseView view, CourseCallback callback) {
        super(view);
        this.callback = callback;
    }

    @Override
    public void activate() {}

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        DefaultListModel<Course> model = new DefaultListModel<>();

        //noinspection unchecked
        model.addAll((List<Course>)(List<?>) CourseRepository.getInstance().getAll());

        view.getCourseList().setModel(model);

        view.getApproveButton().addActionListener(e -> {
            Course course = view.getCourseList().getSelectedValue();
            Navigator.getInstance().pop();
            this.callback.onSelected(course);
        });
    }

    @Override
    public void onDestroy() {}

    public interface CourseCallback {
        void onSelected(Course course);
    }
}