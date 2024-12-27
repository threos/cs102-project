package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.user.Student;

public class UndergraduateStudentRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static UndergraduateStudentRepository instance;

    public static UndergraduateStudentRepository getInstance() {
        if (instance == null) {
            instance = new UndergraduateStudentRepository();
        }
        return instance;
    }

    public UndergraduateStudentRepository() {
        super(StudentRepository.getInstance(), (e) -> e instanceof Student);
    }
}