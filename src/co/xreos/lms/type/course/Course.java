package co.xreos.lms.type.course;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class Course implements SerializableSchemaModel {
    private String name;
    private int capacity;
    private boolean isGraduate;

    public Course(String name, int capacity, boolean isGraduate) {
        this.name = name;
        this.capacity = capacity;
        this.isGraduate = isGraduate;
    }

    public static Course fromProperties(List<String> properties) {
        String name = properties.get(0);
        int capacity = Integer.parseInt(properties.get(1));
        boolean isGraduate = Boolean.parseBoolean(properties.get(2));
        return new Course(name, capacity, isGraduate);
    }

    @Override
    public List<String> toProperties() {
        return List.of(name, String.valueOf(capacity), String.valueOf(isGraduate));
    }
}
