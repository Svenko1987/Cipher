package com.svenko.cipher.controller;

import android.content.Context;
import android.widget.Toast;
import com.svenko.cipher.model.modes.TextDecryptAes;
import com.svenko.cipher.view.TextCipherView;


public class TextDecryptController implements ICipherController<String> {


    private String decryption;
    TextCipherView textCipherView;
    Context context;

    public TextDecryptController(TextCipherView textCipherView, Context context) {
        this.textCipherView = textCipherView;
        this.context = context;
    }


    @Override
    public void onAction(String password, String text) {

        TextDecryptAes textDecryptAes = new TextDecryptAes(password, text);
        textDecryptAes.decrypt();
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
            this.decryption = textDecryptAes.getData();

    }

    public String getDecryption() {
        return decryption;
    }
}
