package co.xreos.lms.type.course;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class StudentCourseEnrollment implements SerializableSchemaModel {
    private String courseId;
    private String student;

    public StudentCourseEnrollment(String courseId, String student) {
        this.courseId = courseId;
        this.student = student;
    }

    public static StudentCourseEnrollment fromProperties(List<String> properties) {
        String courseId = properties.get(0);
        String student = properties.get(1);
        return new StudentCourseEnrollment(courseId, student);
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
