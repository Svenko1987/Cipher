package com.svenko.cipher.model.modes;

public class AesDecrypt implements IDecrypt{
    private String password;
    private String text;
    private String cipher;

    public AesDecrypt(String password, String cipher) {
        this.password = password;
        this.text = cipher;
    }

    @Override
    public void decrypt() {
    this.text=cipher.concat("+"+password);
    }


    @Override
    public String getText() {
        return this.text;
    }
}
