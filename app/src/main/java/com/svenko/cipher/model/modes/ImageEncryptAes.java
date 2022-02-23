package com.svenko.cipher.model.modes;

import android.graphics.Bitmap;

import com.svenko.cipher.model.SecretKey;


public class ImageEncryptAes implements IEncrypt<Bitmap>{
    private String password;
    private Bitmap data;
    private Bitmap cipher;
    SecretKey secretKey;

    public ImageEncryptAes(String password, Bitmap data) {
        this.password = password;
        this.data = data;
    }


    @Override
    public Bitmap getCipher() {
        return this.cipher;
    }

    @Override
    public void Encrypt() {

    }
}
