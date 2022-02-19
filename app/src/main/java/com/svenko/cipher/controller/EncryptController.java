package com.svenko.cipher.controller;

import android.content.Context;
import android.widget.Toast;
import com.svenko.cipher.model.modes.AesEncrypt;
import com.svenko.cipher.view.CipherView;


public class EncryptController implements ICipherController {

    private String encryption;
    CipherView cipherView;
    Context context;

    public EncryptController(CipherView cipherView, Context context) {
        this.cipherView = cipherView;
        this.context = context;

    }


    @Override
    public void onAction(String password, String text) {
        AesEncrypt aesEncrypt = new AesEncrypt(password, text);
        aesEncrypt.Encrypt();
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
            this.encryption = aesEncrypt.getCipher();
    }

    public String getEncryption() {
        return encryption;
    }
}
