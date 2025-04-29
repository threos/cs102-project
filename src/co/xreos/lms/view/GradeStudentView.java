package co.xreos.lms.view;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.GradebookItemRepository;
import co.xreos.lms.repository.StudentCourseEnrollmentRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.type.user.Student;

import javax.swing.*;
import java.awt.*;

public class GradeStudentView extends AppView {
    private JList<StudentCourseEnrollment> studentList;
    private JComboBox<GradebookItem> itemComboBox;
    private JTextField gradeField;
    private JButton gradeButton;

    private Course course;

    public GradeStudentView(Course course) {
        super("Grade Students for " + course.getName());
        this.course = course;
    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(2, 1, 10, 8));
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        studentList = new JList<>(StudentCourseEnrollmentRepository.getInstance().getAll().stream().filter((e) -> ((StudentCourseEnrollment) e).getCourseId().equals(course.getName())).toList().toArray(new StudentCourseEnrollment[0]));
        itemComboBox = new JComboBox<>(GradebookItemRepository.getInstance().getAll().stream().filter((i) -> ((GradebookItem) i).getCourseId().equals(course.getName())).toList().toArray(new GradebookItem[0]));
        gradeField = new JTextField();
        gradeButton = new JButton("Grade");

        JPanel upperPanel = new JPanel();
        upperPanel.add(new JLabel("Student:"));
        upperPanel.add(studentList);

        add(upperPanel);

        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(3, 2, 10, 8));
        lowerPanel.add(new JLabel("Item:"));
        lowerPanel.add(itemComboBox);
        lowerPanel.add(new JLabel("Grade:"));
        lowerPanel.add(gradeField);
        lowerPanel.add(new Container());
        lowerPanel.add(gradeButton);

        add(lowerPanel);
    }

    @Override
    public void deactivate() {

    }

    public JList<StudentCourseEnrollment> getStudentList() {
        return studentList;
    }

    public JComboBox<GradebookItem> getItemComboBox() {
        return itemComboBox;
    }

    public JTextField getGradeField() {
        return gradeField;
    }

    public JButton getGradeButton() {
        return gradeButton;
    }

    public Course getCourse() {
        return course;
    }
}
