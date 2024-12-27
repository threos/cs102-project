package co.xreos.lms.type.announcement;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.List;

public class Announcement implements SerializableSchemaModel {
    private String courseName;
    private String topic;
    private String content;

    public Announcement(String courseName, String topic, String content) {
        this.courseName = courseName;
        this.topic = topic;
        this.content = content;
    }

    public static Announcement fromProperties(List<String> properties) {
        String courseName = properties.get(0);
        String topic = properties.get(1);
        String content = properties.get(2);
        return new Announcement(courseName, topic, content);
    }

    @Override
    public List<String> toProperties() {
        return List.of(courseName, topic, content);
    }
}
