package com.svenko.cipher.model;

public class AesEncrypt implements IEncrypt {
    private String password;
    private String text;
    private String cipher;

    public AesEncrypt(String password, String text) {
        this.password = password;
        this.text = text;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void Encrypt() {
    cipher=text.concat("+"+password);
    }
}
