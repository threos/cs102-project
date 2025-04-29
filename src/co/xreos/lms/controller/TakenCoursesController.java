package co.xreos.lms.controller;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.StudentCourseEnrollmentRepository;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.view.DeleteCourseView;
import co.xreos.lms.view.TakenCoursesView;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TakenCoursesController extends AppController<TakenCoursesView> {
    public TakenCoursesController(TakenCoursesView view) {
        super(view);
    }

    @Override
    public void activate() {
        String name = AuthState.getInstance().getCurrentUser().getName();
        List<String> takenCourses = new ArrayList<>();
        List<SerializableSchemaModel> enrollments = StudentCourseEnrollmentRepository.getInstance().getAll().stream().filter(enrollment -> ((StudentCourseEnrollment) enrollment).getStudent().equals(name)).toList();
        for(SerializableSchemaModel enrollment : enrollments) {
            Course course = (Course) CourseRepository.getInstance().getAll().stream().filter(c -> ((StudentCourseEnrollment) enrollment).getCourseId().equals(((Course) c).getName())).findFirst().orElse(null);
            List<SerializableSchemaModel> otherStudentEnrollments = StudentCourseEnrollmentRepository.getInstance().getAll().stream().filter(e -> ((StudentCourseEnrollment) e).getCourseId().equals(((StudentCourseEnrollment) enrollment).getCourseId())).toList();
            takenCourses.add(((StudentCourseEnrollment) enrollment).getCourseId() + ", " + course.getTeacher() + ", " + course.getLevel() + ", " + otherStudentEnrollments.size() + "/" + course.getCapacity());
        }
        view.getEnrollmentList().setListData(takenCourses.toArray(new String[0]));
        if(view.getEnrollmentList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No courses to view.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getCloseButton().addActionListener(e -> {
            Navigator.getInstance().pop();
        });
    }

    @Override
    public void onDestroy() {}
}