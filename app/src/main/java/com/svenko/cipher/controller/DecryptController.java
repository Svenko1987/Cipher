package com.svenko.cipher.controller;

import android.content.Context;
import android.widget.Toast;


import com.svenko.cipher.model.modes.AesDecrypt;
import com.svenko.cipher.view.CipherView;

import java.util.function.Consumer;


public class DecryptController implements ICipherController {

    private String decryption;
    // todo: Beskorisno polje.
    CipherView cipherView;
    Context context;

    public DecryptController(CipherView cipherView, Context context) {
        this.cipherView = cipherView;
        this.context= context;
    }

    @Override
    public void onAction(String password, String text) {

        AesDecrypt aesDecrypt=new AesDecrypt(password,text);
        aesDecrypt.decrypt();
        // todo: if (password.isEmpty()) {...}
        // todo: vitičaste zagrade su bitne za čitljivost
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
