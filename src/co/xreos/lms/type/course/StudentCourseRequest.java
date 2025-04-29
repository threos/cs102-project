package co.xreos.lms.type.course;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class StudentCourseRequest implements SerializableSchemaModel {
    private String courseId;
    private String student;

    public StudentCourseRequest(String courseId, String student) {
        this.courseId = courseId;
        this.student = student;
    }

    public static StudentCourseRequest fromProperties(List<String> properties) {
        String courseId = properties.get(0);
        String student = properties.get(1);
        return new StudentCourseRequest(courseId, student);
    }

    @Override
    public List<String> toProperties() {
        return List.of(courseId, student);
    }

    @Override
    public String toString() {
        return student + " -> " + courseId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getStudent() {
        return this.student;
    }
}
