package co.xreos.lms.type.grade;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class GradebookItem implements SerializableSchemaModel {
    private String courseId;
    private GradebookItemType type;

    public GradebookItem(String courseId, GradebookItemType type) {
        this.courseId = courseId;
        this.type = type;
    }

    public static GradebookItem fromProperties(List<String> properties) {
        String courseId = properties.get(0);
        GradebookItemType type = GradebookItemType.valueOf(properties.get(1));
        return new GradebookItem(courseId, type);
    }

    @Override
    public List<String> toProperties() {
        return List.of(courseId, type.toString());
    }

    public enum GradebookItemType {
        MIDTERM,
        FINAL,
        COMPOSITE,
    }
}