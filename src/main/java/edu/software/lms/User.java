package edu.software.lms;

import java.util.Objects;

public class User {
    private String username;
    private  String password;
    private String  id; //


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
public boolean checkPassword(String password) {
  return this.password.equals(password);

}
    @Override
    public String toString() {
        return "User{id='" + id + "', username='" + username + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getUsername());
        result = 31 * result + Objects.hashCode(getPassword());
        result = 31 * result + Objects.hashCode(getId());
        return result;
    }
}
