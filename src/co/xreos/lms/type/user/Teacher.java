package co.xreos.lms.type.user;

import java.util.List;

public class Teacher extends User {
    public Teacher(String name, String hash, String salt) {
        super(name, hash, salt);
    }

    public static Teacher fromProperties(List<String> properties) {
        String name = properties.get(0);
        String hash = properties.get(1);
        String salt = properties.get(2);
        return new Teacher(name, hash, salt);
    }
}
