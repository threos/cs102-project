package co.xreos.lms.controller;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.StudentGradeRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.type.grade.StudentGrade;
import co.xreos.lms.view.ChooseCourseView;
import co.xreos.lms.view.GradeStudentView;

import javax.swing.*;
import java.util.List;

public class GradeStudentController extends AppController<GradeStudentView> {
    public GradeStudentController(GradeStudentView view) {
        super(view);
    }

    @Override
    public void activate() {
        if(view.getStudentList().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(view, "No students enrolled in this course.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
            return;
        }

        updateView();
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getStudentList().addListSelectionListener(e -> {
            updateView();
        });

        view.getGradeButton().addActionListener(e -> {
            save();
        });
    }

    private void save() {
        try {
            StudentCourseEnrollment enrollment = view.getStudentList().getSelectedValue();
            if(enrollment == null) {
                JOptionPane.showMessageDialog(view, "Please select a student to grade.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            GradebookItem.GradebookItemType type = ((GradebookItem) view.getItemComboBox().getSelectedItem()).getType();
            if(type == null) {
                JOptionPane.showMessageDialog(view, "Please select a grade type.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double score = Double.parseDouble(view.getGradeField().getText());
            if(score < 0 || score > 100) {
                JOptionPane.showMessageDialog(view, "Grade must be between 0 and 100.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SerializableSchemaModel grade = StudentGradeRepository.getInstance().getAll().stream().filter(g -> ((StudentGrade) g).getStudent().equals(enrollment.getStudent()) && ((StudentGrade) g).getCourseId().equals(enrollment.getCourseId())).findFirst().orElse(null);
            if(grade == null) {
                grade = new StudentGrade(enrollment.getCourseId(), enrollment.getStudent(), type, score);
            }
            StudentGradeRepository.getInstance().add(grade);
            JOptionPane.showMessageDialog(view, "Grade saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Grade must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(view, "An error occurred while saving the grade.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void updateView() {
        StudentCourseEnrollment enrollment = view.getStudentList().getSelectedValue();
        if(enrollment == null) {
            return;
        }
        SerializableSchemaModel grade = StudentGradeRepository.getInstance().getAll().stream().filter(g -> ((StudentGrade) g).getStudent().equals(enrollment.getStudent()) && ((StudentGrade) g).getCourseId().equals(enrollment.getCourseId())).findFirst().orElse(null);
        if(grade == null) return;

        view.getGradeField().setText(((StudentGrade) grade).getStudent());
        view.getItemComboBox().setSelectedItem(((StudentGrade) grade).getGradeType());
    }

    @Override
    public void onDestroy() {}
}