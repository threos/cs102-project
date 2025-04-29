package co.xreos.lms.controller;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.StudentCourseEnrollmentRepository;
import co.xreos.lms.repository.StudentGradeRepository;
import co.xreos.lms.state.AuthState;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.grade.StudentGrade;
import co.xreos.lms.view.ExamResultView;
import co.xreos.lms.view.TakenCoursesView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ExamResultController extends AppController<ExamResultView> {
    private final Course course;
    public ExamResultController(ExamResultView view, Course course) {
        super(view);
        this.course = course;
    }

    @Override
    public void activate() {
        String name = AuthState.getInstance().getCurrentUser().getName();
        List<String> data = new ArrayList<>();

        List<SerializableSchemaModel> grades = StudentGradeRepository.getInstance().getAll().stream().filter(g -> ((StudentGrade) g).getCourseId().equals(course.getName()) && ((StudentGrade) g).getStudent().equals(name)).toList();

        for(SerializableSchemaModel grade : grades) {
            data.add(((StudentGrade) grade).getGradeType().toString() + ": " + ((StudentGrade) grade).getGrade());
        }
        view.getList().setListData(data.toArray(new String[0]));
        if(view.getList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No data.", "Error", JOptionPane.ERROR_MESSAGE);
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