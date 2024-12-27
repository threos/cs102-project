package co.xreos.lms.type.user;

import java.util.List;

public class TA extends User {
    public TA(String name, String hash, String salt) {
        super(name, hash, salt);
    }

    public static TA fromProperties(List<String> properties) {
        String name = properties.get(0);
        String hash = properties.get(1);
        String salt = properties.get(2);
        return new TA(name, hash, salt);
    }
}
