package edu.software.lms;

public interface UserRepository {

    User getUserById(String id);
    User getUserByUsername(String username);
    boolean addUser(User user);
    boolean deleteUser(String id);
    /**
     * Validate credentials: returns true if username exists and password matches.
     */
    boolean validateCredentials(String username, String password);
}
