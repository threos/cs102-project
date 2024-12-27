package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.user.Student;

public class TARepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static TARepository instance;

    public static TARepository getInstance() {
        if (instance == null) {
            instance = new TARepository();
        }
        return instance;
    }

    public TARepository() {
        super(StudentRepository.getInstance(), (e) -> e instanceof Student);
    }
}