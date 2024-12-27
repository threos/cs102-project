package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;

public class StudentCourseEnrollmentRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static StudentCourseEnrollmentRepository instance;

    public static StudentCourseEnrollmentRepository getInstance() {
        if (instance == null) {
            instance = new StudentCourseEnrollmentRepository();
        }
        return instance;
    }

    public StudentCourseEnrollmentRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof StudentCourseEnrollment);
    }
}