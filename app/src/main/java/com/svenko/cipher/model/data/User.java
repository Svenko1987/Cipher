package com.svenko.cipher.model.data;

public class User {
    private String name;
    private byte[] password;
    private byte[] nukePassword;

    public User() {
    }

    public User(String name, byte[] password, byte[] nukePassword) {
        this.name = name;
        this.password = password;
        this.nukePassword = nukePassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public byte[] getNukePassword() {
        return nukePassword;
    }

    public void setNukePassword(byte[] nukePassword) {
        this.nukePassword = nukePassword;
    }
}
