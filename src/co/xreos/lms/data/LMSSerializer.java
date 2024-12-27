package co.xreos.lms.data;

import co.xreos.lms.type.announcement.Announcement;
import co.xreos.lms.type.course.Course;
import co.xreos.lms.type.course.StudentCourseEnrollment;
import co.xreos.lms.type.course.StudentCourseRequest;
import co.xreos.lms.type.grade.GradebookItem;
import co.xreos.lms.type.grade.StudentGrade;
import co.xreos.lms.type.user.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LMSSerializer {
    public String serialize(List<SerializableSchemaModel> model) {
        StringBuilder sb = new StringBuilder();
        for (SerializableSchemaModel m : model) {
            String typeName = getTypeNameByModel(m);
            sb.append(typeName).append(",");
            List<String> properties = m.toProperties();
            for (int i = 0; i < properties.size(); i++) {
                // Escape commas
                String property = properties.get(i);
                property = property.replace(",", "[COMMA]");
                sb.append(property);
                if (i < properties.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<SerializableSchemaModel> deserialize(String data) {
        List<SerializableSchemaModel> models = new ArrayList<>();
        for (String line : data.split("\n")) {
            String[] p0 = line.split(",");
            if(p0.length == 0) {
                continue;
            }
            String[] parts = Arrays.stream(p0).map(s -> s.replace("[COMMA]", ",")).toArray(String[]::new);
            String typeName = parts[0];
            List<String> properties = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
            models.add(constructModelByTypeName(typeName, properties));
        }
        return models;
    }

    public SerializableSchemaModel constructModelByTypeName(String type, List<String> properties) {
        return switch (type) {
            case "TA" -> TA.fromProperties(properties);
            case "UndergraduateStudent" -> UndergraduateStudent.fromProperties(properties);
            case "Student" -> Student.fromProperties(properties);
            case "Teacher" -> Teacher.fromProperties(properties);
            case "User" -> User.fromProperties(properties);
            case "Course" -> Course.fromProperties(properties);
            case "StudentCourseRequest" -> StudentCourseRequest.fromProperties(properties);
            case "StudentCourseEnrollment" -> StudentCourseEnrollment.fromProperties(properties);
            case "Announcement" -> Announcement.fromProperties(properties);
            case "GradebookItem" -> GradebookItem.fromProperties(properties);
            case "StudentGrade" -> StudentGrade.fromProperties(properties);
            default -> null;
        };
    }

    public String getTypeNameByModel(SerializableSchemaModel model) {
        if (model instanceof TA) {
            return "TA";
        } else if (model instanceof UndergraduateStudent) {
            return "UndergraduateStudent";
        } else if (model instanceof Student) {
            return "Student";
        } else if (model instanceof Teacher) {
            return "Teacher";
        } else if (model instanceof User) {
            return "User";
        } else if (model instanceof Course) {
            return "Course";
        } else if (model instanceof StudentCourseRequest) {
            return "StudentCourseRequest";
        } else if (model instanceof StudentCourseEnrollment) {
            return "StudentCourseEnrollment";
        } else if (model instanceof Announcement) {
            return "Announcement";
        } else if (model instanceof GradebookItem) {
            return "GradebookItem";
        } else if (model instanceof StudentGrade) {
            return "StudentGrade";
        } else {
            throw new IllegalArgumentException("Unknown model type: " + model.getClass().getName());
        }
    }
}
