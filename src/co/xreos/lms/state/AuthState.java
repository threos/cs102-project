package co.xreos.lms.state;

import co.xreos.lms.repository.CoreRepository;
import co.xreos.lms.repository.UserRepository;
import co.xreos.lms.type.user.User;
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

    public User login(String name, String password) {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.getAll().stream()
                .filter(e -> e instanceof User)
                .map(e -> (User) e)
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .filter(e -> e.getHash().equals(Crypto.hash(password, e.getSalt())))
                .ifPresent(e -> currentUser = e);
        userRepository.getAll().forEach(e -> {
            System.out.println("User: " + ((User) e).getName() + " " + ((User) e).getHash() + " " + ((User) e).getSalt() + "<=> " + Crypto.hash(password, ((User) e).getSalt()));
        });
        return currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
