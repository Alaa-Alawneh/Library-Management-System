package edu.software.lms;

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




}
