package co.xreos.lms.type.user;

import java.util.List;

public class Student extends User {
    public Student(String name, String hash, String salt) {
        super(name, hash, salt);
    }

    public static Student fromProperties(List<String> properties) {
        String name = properties.get(0);
        String hash = properties.get(1);
        String salt = properties.get(2);
        return new Student(name, hash, salt);
    }
}
