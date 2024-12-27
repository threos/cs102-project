package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.user.User;

public class UserRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public UserRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof User);
    }
}