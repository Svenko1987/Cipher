package com.svenko.cipher.model.modes;

public class AesDecrypt implements IDecrypt{
    private String password;
    private String text;
    private String cipher;

    public AesDecrypt(String password, String cipher) {
        this.password = password;
        this.cipher = cipher;
    }

    @Override
    public void decrypt() {
    this.text=cipher.concat(" desifrovano sa  sifrom "+password);

    }


    @Override
    public String getText() {
        return this.text;
    }
}
