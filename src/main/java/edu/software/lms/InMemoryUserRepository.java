package edu.software.lms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    public InMemoryUserRepository(List<User> initial) {
        this.users = new ArrayList<>();
        if (initial != null) this.users.addAll(initial);
    }

    @Override
    public User getUserById(String id) {
        if (id == null) return null;
        return users.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        if (username == null) return null;
        return users.stream()
                .filter(u -> username.equals(u.getUsername()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean addUser(User user) {
        if (user == null || user.getUsername() == null) return false;
        // prevent duplicate username or id
        boolean exists = users.stream().anyMatch(u ->
                (u.getId() != null && u.getId().equals(user.getId()))
                        || (u.getUsername() != null && u.getUsername().equals(user.getUsername()))
        );
        if (exists) return false;
        users.add(user);
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        Optional<User> found = users.stream().filter(u -> id != null && id.equals(u.getId())).findFirst();
        if (found.isPresent()) {
            users.remove(found.get());
            return true;
        }
        return false;
    }

    @Override
    public Pair<User,LoginResult> validateCredentials(String username, String password) {
        if (username == null) return new Pair<>(null, LoginResult.INVALID_USERNAME);
        if (password == null) return new Pair<>(null, LoginResult.INVALID_PASSWORD);
        User user = users.stream()
                .filter(u -> username.equals(u.getUsername())).findFirst().orElse(null);
        if (user == null) return new Pair<>(null, LoginResult.NO_USER_FOUND);
        if(user.checkPassword(password))
            return new Pair<>(user,LoginResult.USER_FOUND_SUCCESSFULLY);
        return new Pair<>(null,LoginResult.USER_FOUND_WRONG_PASSWORD);


    }
}
