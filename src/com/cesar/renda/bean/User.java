package com.cesar.renda.bean;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private int userType;
    private String fullName;
    private String username;
    private String password;

    public User() {
    }

    public User(int userType, String fullName, String username, String password) {
        this.userType = userType;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public User(int id, int userType, String fullName, String username, String password) {
        this.id = id;
        this.userType = userType;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userType=" + userType + ", fullName=" + fullName + ", username=" + username + ", password=" + password + '}';
    }

    public boolean isEmpty(){
        return (userType <= 0  && fullName == null && username == null && password == null);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

}
