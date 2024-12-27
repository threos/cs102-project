package co.xreos.lms.type.course;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class StudentCourseEnrollment implements SerializableSchemaModel {
    private String courseId;
    private String studentId;

    public StudentCourseEnrollment(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public static StudentCourseEnrollment fromProperties(List<String> properties) {
        String courseId = properties.get(0);
        String studentId = properties.get(1);
        return new StudentCourseEnrollment(courseId, studentId);
    }

    @Override
    public List<String> toProperties() {
        return List.of(courseId, studentId);
    }
}
