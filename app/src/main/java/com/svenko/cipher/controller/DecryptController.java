package com.svenko.cipher.controller;

import android.content.Context;
import android.util.Base64;
import android.widget.Toast;


import com.svenko.cipher.model.SecretKey;
import com.svenko.cipher.model.modes.AesDecrypt;
import com.svenko.cipher.view.CipherView;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class DecryptController implements ICipherController {
    SecretKey secretKey;

    private String decryption;
    CipherView cipherView;
    Context context;

    public DecryptController(CipherView cipherView, Context context) {
        this.cipherView = cipherView;
        this.context= context;
    }
    public String decrypt(String data , String key) throws Exception{
        if (key.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (data.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        if (!key.equals("") && !data.equals("")) {

            this.secretKey= new SecretKey(key);
            SecretKeySpec keySpec = secretKey.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decVal= Base64.decode(data, Base64.DEFAULT);
            byte[] decodedValue= cipher.doFinal(decVal);
            String decryptedValue= new String(decodedValue);
            return decryptedValue;

        }else return data;


    }

    @Override
    public void onAction(String password, String text) {

        AesDecrypt aesDecrypt=new AesDecrypt(password,text);
        aesDecrypt.decrypt();
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
        this.decryption=aesDecrypt.getText();

    }

    public String getDecryption() {
        return decryption;
    }
}
