package co.xreos.lms.controller;

import co.xreos.lms.navigation.base.controller.AppController;
import co.xreos.lms.navigation.navigator.Navigator;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.repository.GradebookItemRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.view.CreateCourseView;
import co.xreos.lms.view.CreateGradebookItemView;

import javax.swing.*;

public class CreateGradebookItemController extends AppController<CreateGradebookItemView> {
    public CreateGradebookItemController(CreateGradebookItemView view) {
        super(view);
    }

    @Override
    public void activate() {
        if(view.getCourseComboBox().getItemCount() == 0) {
            JOptionPane.showMessageDialog(view, "No courses available. Please create a course first.", "Error", JOptionPane.ERROR_MESSAGE);
            Navigator.getInstance().pop();
        }
    }

    @Override
    public void deactivate() {}

    @Override
    public void onCreate() {
        view.getCreateButton().addActionListener(e -> {
            createGradebookItem((Course) view.getCourseComboBox().getSelectedItem(), (GradebookItem.GradebookItemType) view.getItemTypeComboBox().getSelectedItem());
        });
    }

    private void createGradebookItem(Course course, GradebookItem.GradebookItemType type) {
        if(course == null) {
            JOptionPane.showMessageDialog(view, "Please select a course.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        GradebookItemRepository.getInstance().add(new GradebookItem(course.getName(), type));
        JOptionPane.showMessageDialog(view, "Gradebook item created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        Navigator.getInstance().pop();
    }

    @Override
    public void onDestroy() {}
}