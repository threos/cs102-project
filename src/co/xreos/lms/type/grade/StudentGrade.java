package co.xreos.lms.type.grade;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class StudentGrade implements SerializableSchemaModel {
    private String courseId;
    private String studentName;
    private GradebookItem.GradebookItemType gradeType;
    private double grade;

    public StudentGrade(String courseId, String studentName, GradebookItem.GradebookItemType gradeType, double grade) {
        this.courseId = courseId;
        this.studentName = studentName;
        this.gradeType = gradeType;
        this.grade = grade;
    }

    public static StudentGrade fromProperties(List<String> properties) {
        String courseId = properties.get(0);
        String studentName = properties.get(1);
        GradebookItem.GradebookItemType gradeType = GradebookItem.GradebookItemType.valueOf(properties.get(2));
        double grade = Double.parseDouble(properties.get(3));
        return new StudentGrade(courseId, studentName, gradeType, grade);
    }

    @Override
    public List<String> toProperties() {
        return List.of(courseId, studentName, gradeType.toString(), String.valueOf(grade));
    }
}