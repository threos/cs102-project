package co.xreos.lms.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SimpleStorage {
    private final File file;
    public SimpleStorage() {
        file = new File("data.txt");
    }

    public String load() throws IOException {
        if (!file.exists()) {
            return null;
        }
        return Files.readString(file.toPath());
    }

    public void reset() {
        if (file.exists()) {
            file.delete();
        }
    }

    public void save(String data) {
        try {
            Files.writeString(file.toPath(), data);
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
