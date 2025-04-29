package co.xreos.lms.data;

import co.xreos.lms.repository.CoreRepository;
import co.xreos.lms.repository.IRepository;
import co.xreos.lms.storage.SimpleStorage;

public class DataSync {
    private static SimpleStorage storage = new SimpleStorage();
    private static LMSSerializer serializer = new LMSSerializer();

    public static void attachTo(IRepository<SerializableSchemaModel> repository) {
        repository.addListener(() -> {
            save(repository);
        });
    }

    private static void save(IRepository<SerializableSchemaModel> repository) {
        storage.save(serializer.serialize(repository.getAll()));
    }
}
