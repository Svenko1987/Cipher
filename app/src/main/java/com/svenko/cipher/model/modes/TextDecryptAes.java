package com.svenko.cipher.model.modes;

import android.util.Base64;

import com.svenko.cipher.model.SecretKey;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class TextDecryptAes implements IDecrypt <String> {
    private String key;
    private String text;
    private String data;
    SecretKey secretKey;

    public TextDecryptAes(String key, String data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public void decrypt() {

        this.secretKey = new SecretKey(key);
        SecretKeySpec keySpec = secretKey.getSecretKey();
        byte[] decodedValue = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decVal = Base64.decode(data, Base64.DEFAULT);
            decodedValue = cipher.doFinal(decVal);
        } catch (NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        this.text = new String(decodedValue);

    }


    @Override
    public String getData() {
        return this.text;
    }
}
