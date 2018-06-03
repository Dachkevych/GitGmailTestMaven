package com.epam.lab.github.dataobject;

public class UserModelGithub {

    private String login;
    private String password;

    public UserModelGithub(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserModelGithub{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
