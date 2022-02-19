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

public class AesEncrypt implements IEncrypt {
    private String password;
    private String text;
    private String cipher;
    SecretKey secretKey;

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

        this.secretKey = new SecretKey(password);
        SecretKeySpec keySpec = secretKey.getSecretKey();
        byte[] encVal = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            encVal = cipher.doFinal(text.getBytes());
        } catch (NoSuchAlgorithmException e) {
            extracted(e);
        } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        this.cipher= Base64.encodeToString(encVal, Base64.DEFAULT);

    }

    private void extracted(NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
}
