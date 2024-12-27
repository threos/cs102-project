package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.ArrayList;
import java.util.List;

public class CoreRepository extends IRepository<SerializableSchemaModel> {
    private static CoreRepository instance;

    private CoreRepository() {}

    public static CoreRepository getInstance() {
        if (instance == null) {
            instance = new CoreRepository();
        }
        return instance;
    }

    private List<SerializableSchemaModel> data = new ArrayList<>();

    @Override
    public SerializableSchemaModel add(SerializableSchemaModel entity) {
        return mutationContract(() -> {
            data.add(entity);
            return entity;
        });
    }

    @Override
    public List<SerializableSchemaModel> addAll(List<SerializableSchemaModel> entities) {
        return mutationContract(() -> {
            data.addAll(entities);
            return entities;
        });
    }

    @Override
    public SerializableSchemaModel update(SerializableSchemaModel entity) {
        return mutationContract(() -> entity);
    }

    @Override
    public SerializableSchemaModel delete(SerializableSchemaModel entity) {
        return mutationContract(() -> {
            data.remove(entity);
            return entity;
        });
    }

    @Override
    public List<SerializableSchemaModel> getAll() {
        return data;
    }
}
