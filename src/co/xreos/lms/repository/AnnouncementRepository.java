package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.grade.GradebookItem;

public class AnnouncementRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static AnnouncementRepository instance;

    public static AnnouncementRepository getInstance() {
        if (instance == null) {
            instance = new AnnouncementRepository();
        }
        return instance;
    }

    public AnnouncementRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof GradebookItem);
    }
}