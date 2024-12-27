package co.xreos.lms.type.user;

import java.util.List;

public class UndergraduateStudent extends User {
    public UndergraduateStudent(String name, String hash, String salt) {
        super(name, hash, salt);
    }

    public static UndergraduateStudent fromProperties(List<String> properties) {
        String name = properties.get(0);
        String hash = properties.get(1);
        String salt = properties.get(2);
        return new UndergraduateStudent(name, hash, salt);
    }
}
