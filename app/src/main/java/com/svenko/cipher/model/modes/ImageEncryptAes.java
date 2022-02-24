package com.svenko.cipher.model.modes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.svenko.cipher.model.SecretKey;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


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
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] bytes= stream.toByteArray();
        this.secretKey = new SecretKey(password);
        SecretKeySpec keySpec = secretKey.getSecretKey();
        byte[] encVal = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            encVal = cipher.doFinal(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        String imageEncoded = Base64.encodeToString(encVal, Base64.DEFAULT);
        byte[] decodedByte = Base64.decode(imageEncoded, 0);
        this.cipher= BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);

    }
}
