package co.xreos.lms.repository;

import co.xreos.lms.data.SerializableSchemaModel;
import co.xreos.lms.type.course.StudentCourseRequest;
import co.xreos.lms.type.grade.GradebookItem;

public class GradebookItemRepository extends FilteredViewRepository<SerializableSchemaModel> {
    private static GradebookItemRepository instance;

    public static GradebookItemRepository getInstance() {
        if (instance == null) {
            instance = new GradebookItemRepository();
        }
        return instance;
    }

    public GradebookItemRepository() {
        super(CoreRepository.getInstance(), (e) -> e instanceof GradebookItem);
    }
}