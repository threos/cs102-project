package co.xreos.lms.view;

import co.xreos.lms.navigation.base.view.AppView;
import co.xreos.lms.repository.CourseRepository;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.CourseLevel;
import co.xreos.lms.type.grade.GradebookItem;

import javax.swing.*;
import java.awt.*;

public class CreateGradebookItemView extends AppView {
    private JComboBox<Course> courseComboBox;
    private JComboBox<GradebookItem.GradebookItemType> itemTypeComboBox;
    private JButton createButton;

    public CreateGradebookItemView() {
        super("Create Gradebook Item");
    }

    @Override
    public void onCreate() {
        setLayout(new GridLayout(3, 2, 10, 8));
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        courseComboBox = new JComboBox<>(CourseRepository.getInstance().getAll().toArray(new Course[0]));
        itemTypeComboBox = new JComboBox<>(GradebookItem.GradebookItemType.values());
        createButton = new JButton("Create");

        add(new JLabel("Course:"));
        add(courseComboBox);
        add(new JLabel("Type:"));
        add(itemTypeComboBox);
        add(new Container());
        add(createButton);
    }

    @Override
    public void deactivate() {

    }

    public JComboBox<Course> getCourseComboBox() {
        return courseComboBox;
    }

    public JComboBox<GradebookItem.GradebookItemType> getItemTypeComboBox() {
        return itemTypeComboBox;
    }

    public JButton getCreateButton() {
        return createButton;
    }
}
