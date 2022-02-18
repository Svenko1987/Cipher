package com.svenko.cipher.controller;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;

import com.svenko.cipher.model.SecretKey;
import com.svenko.cipher.model.modes.AesEncrypt;
import com.svenko.cipher.view.CipherView;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class EncryptController implements ICipherController {

    private String encryption;
    CipherView cipherView;
    Context context;
    SecretKey secretKey;

    public EncryptController(CipherView cipherView, Context context) {
        this.cipherView = cipherView;
        this.context=context;

    }

    public String encrypt(String data, String key) throws Exception {
        if (key.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (data.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();

        if (!key.equals("") && !data.equals("")) {
            this.secretKey = new SecretKey(key);
            SecretKeySpec keySpec = secretKey.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encVal = cipher.doFinal(data.getBytes());
            String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);
            return encryptedValue;
        }else return data;



    }

    @Override
    public void onAction(String password, String text) {
        AesEncrypt aesEncrypt=new AesEncrypt(password,text);
        aesEncrypt.Encrypt();
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
        this.encryption=aesEncrypt.getCipher();
    }

    public String getEncryption() {
        return encryption;
    }
}
