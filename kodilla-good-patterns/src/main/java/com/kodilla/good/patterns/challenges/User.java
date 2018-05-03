package com.kodilla.good.patterns.challenges;

public class User {
    private int userID;
    private String userName;
    private String userSurname;
    private String userLogin;

    public User(int userID, String userName, String userSurname, String userLogin) {
        this.userID = userID;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userLogin = userLogin;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getUserLogin() {
        return userLogin;
    }
}
