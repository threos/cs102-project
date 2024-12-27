package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.user.User;

public class CourseRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static CourseRepository instance;

    public static CourseRepository getInstance() {
        if (instance == null) {
            instance = new CourseRepository();
        }
        return instance;
    }

    public CourseRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof Course);
    }
}