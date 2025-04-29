package co.xreos.lms.state;

import co.xreos.lms.repository.CoreRepository;
import co.xreos.lms.repository.UserRepository;
import co.xreos.lms.type.user.*;
import co.xreos.lms.utils.Crypto;

public class AuthState {
    private static AuthState instance;
    private User currentUser = null;

    public static AuthState getInstance() {
        if (instance == null) {
            instance = new AuthState();
        }
        return instance;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }

    public User login(String name, String password, Role role) {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.getAll().stream()
                .filter(e -> {
                    switch (role) {
                        case TEACHER:
                            return e instanceof Teacher;
                        case TA:
                            return e instanceof TA;
                        case STUDENT:
                            return e instanceof Student;
                        default:
                            return false;
                    }
                })
                .map(e -> (User) e)
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .filter(e -> e.getHash().equals(Crypto.hash(password, e.getSalt())))
                .ifPresent(e -> currentUser = e);
        return currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }
}
