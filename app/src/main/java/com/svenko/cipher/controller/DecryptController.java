package com.svenko.cipher.controller;

import android.content.Context;
import android.widget.Toast;
import com.svenko.cipher.model.modes.AesDecrypt;
import com.svenko.cipher.view.TextCipherView;


public class DecryptController implements ICipherController {


    private String decryption;
    TextCipherView textCipherView;
    Context context;

    public DecryptController(TextCipherView textCipherView, Context context) {
        this.textCipherView = textCipherView;
        this.context = context;
    }


    @Override
    public void onAction(String password, String text) {

        AesDecrypt aesDecrypt = new AesDecrypt(password, text);
        aesDecrypt.decrypt();
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
            this.decryption = aesDecrypt.getText();

    }

    public String getDecryption() {
        return decryption;
    }
}
