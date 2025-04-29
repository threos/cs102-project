package co.xreos.lms.view;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.repository.GradebookItemRepository;
import co.xreos.lms.repository.StudentCourseEnrollmentRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.grade.GradebookItem;

import javax.swing.*;
import java.awt.*;

public class ParticipantsView extends AppView {
    private JList<SerializableSchemaModel> studentList;

    private Course course;

    public ParticipantsView(Course course) {
        super("View Participants for " + course.getName());
        this.course = course;
    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(1, 1, 10, 8));
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        studentList = new JList<>(StudentCourseEnrollmentRepository.getInstance().getAll().stream().filter((e) -> ((StudentCourseEnrollment) e).getCourseId().equals(course.getName())).toList().toArray(new StudentCourseEnrollment[0]));

        add(studentList);
    }

    @Override
    public void deactivate() {

    }

    public JList<SerializableSchemaModel> getStudentList() {
        return studentList;
    }
}
