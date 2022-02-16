package com.svenko.cipher.model.modes;

public class AesEncrypt implements IEncrypt {
    private String password;
    private String text;
    private String cipher;

    public AesEncrypt(String password, String text) {
        this.password = password;
        this.text = text;
    }

    @Override
    public String getCipher() {
        return this.cipher;
    }



    @Override
    public void Encrypt() {
    cipher=text.concat("+"+password);
    }
}
