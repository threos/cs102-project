package co.xreos.lms.data;

import co.xreos.lms.repository.CoreRepository;
import co.xreos.lms.repository.IRepository;
import co.xreos.lms.repository.UserRepository;
import co.xreos.lms.storage.SimpleStorage;
import co.xreos.lms.type.user.Student;
import co.xreos.lms.type.user.TA;
import co.xreos.lms.type.user.Teacher;
import co.xreos.lms.type.user.User;
import co.xreos.lms.utils.Crypto;

import java.io.IOException;
import java.util.List;

public class DataLoader {
    private static SimpleStorage storage = new SimpleStorage();
    private static LMSSerializer serializer = new LMSSerializer();

    public static void loadAllData(IRepository<SerializableSchemaModel> repository) throws IOException {
        String raw = storage.load();

        if (raw == null) {
            String salt0 = Crypto.generateSalt();
            String salt1 = Crypto.generateSalt();
            String salt2 = Crypto.generateSalt();

            Teacher u0 = new Teacher("ali", Crypto.hash("123", salt0), salt0);
            TA u1 = new TA("jane", Crypto.hash("123", salt1), salt1);
            Student u2 = new Student("john", Crypto.hash("123", salt2), salt2);

            repository.addAll(List.of(u0, u1, u2));
            return;
        }

        repository.addAll(serializer.deserialize(raw));
    }

    public static void reset() {
        storage.reset();
    }
}
