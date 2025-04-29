package co.xreos.lms.controller;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.StudentCourseEnrollmentRepository;
import co.xreos.lms.repository.StudentGradeRepository;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.type.grade.StudentGrade;
import co.xreos.lms.view.GradeStudentView;
import co.xreos.lms.view.ParticipantsView;

import javax.swing.*;

public class ParticipantsController extends AppController<ParticipantsView> {
    public ParticipantsController(ParticipantsView view) {
        super(view);
    }

    @Override
    public void activate() {
        if(view.getStudentList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No students enrolled in this course.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
            return;
        }

        DefaultListModel<SerializableSchemaModel> model = new DefaultListModel<>();

        model.addAll(StudentCourseEnrollmentRepository.getInstance().getAll().stream().filter((e) -> ((StudentCourseEnrollment) e).getCourseId().equals(view.getName())).toList());

        view.getStudentList().setModel(model);
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
    }


    @Override
    public void onDestroy() {}
}