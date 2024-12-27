package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.course.StudentCourseRequest;

public class StudentCourseRequestRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static StudentCourseRequestRepository instance;

    public static StudentCourseRequestRepository getInstance() {
        if (instance == null) {
            instance = new StudentCourseRequestRepository();
        }
        return instance;
    }

    public StudentCourseRequestRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof StudentCourseRequest);
    }
}