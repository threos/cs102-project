package co.xreos.lms.type.course;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class StudentCourseRequest implements SerializableSchemaModel {
    private String courseId;
    private String studentId;

    public StudentCourseRequest(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public static StudentCourseRequest fromProperties(List<String> properties) {
        String courseId = properties.get(0);
        String studentId = properties.get(1);
        return new StudentCourseRequest(courseId, studentId);
    }

    @Override
    public List<String> toProperties() {
        return List.of(courseId, studentId);
    }
}
