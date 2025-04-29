package co.xreos.lms.type.course;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;
import java.util.logging.Level;

public class Course implements SerializableSchemaModel {
    private String name;
    private int capacity;
    private String teacher;
    private CourseLevel level;

    public Course(String name, int capacity, String teacher, CourseLevel level) {
        this.name = name;
        this.capacity = capacity;
        this.teacher = teacher;
        this.level = level;
    }

    public static Course fromProperties(List<String> properties) {
        String name = properties.get(0);
        int capacity = Integer.parseInt(properties.get(1));
        String teacher = properties.get(2);
        CourseLevel level = CourseLevel.valueOf(properties.get(3));
        return new Course(name, capacity, teacher, level);
    }

    @Override
    public List<String> toProperties() {
        return List.of(name, String.valueOf(capacity), teacher, level.name());
    }

    @Override
    public String toString() {
        return name + " (" + level + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Course course) {
            return course.name.equals(name) && course.capacity == capacity && course.level == level && course.teacher.equals(teacher);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + capacity + level.hashCode();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public CourseLevel getLevel() {
        return this.level;
    }
}
