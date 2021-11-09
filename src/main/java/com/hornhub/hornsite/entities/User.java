package com.hornhub.hornsite.entities;

import java.util.Objects;

public class User {

    private  int id;
    private String username;
    private String password;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {return this.id;}

    public void setId(int id) {this.id = id;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return "User{" + "username='" + username + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        if (!Objects.equals(username, user.username)) return false;
        return Objects.equals(password, user.password);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
