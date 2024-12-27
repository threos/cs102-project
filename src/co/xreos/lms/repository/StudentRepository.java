package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.type.user.Student;

public class StudentRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static StudentRepository instance;

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public StudentRepository() {
        super(UserRepository.getInstance(), (e) -> e instanceof Student);
    }
}