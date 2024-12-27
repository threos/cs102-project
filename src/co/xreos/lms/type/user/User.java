package co.xreos.lms.type.user;

import co.xreos.lms.data.SerializableSchemaModel;

import java.util.ArrayList;
import java.util.List;

public class User implements SerializableSchemaModel {
    final String name;
    final String hash;
    final String salt;

    public User(String name, String hash, String salt) {
        this.name = name;
        this.hash = hash;
        this.salt = salt;
    }

    public static User fromProperties(List<String> properties) {
        String name = properties.get(0);
        String hash = properties.get(1);
        String salt = properties.get(2);
        return new User(name, hash, salt);
    }

    @Override
    public List<String> toProperties() {
        return List.of(name, hash, salt);
    }

    public String getName() {
        return this.name;
    }

    public String getHash() {
        return this.hash;
    }

    public String getSalt() {
        return this.salt;
    }
}
