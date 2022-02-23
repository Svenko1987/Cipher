package com.svenko.cipher.controller;

import android.content.Context;
import android.widget.Toast;
import com.svenko.cipher.model.modes.TextEncryptAes;
import com.svenko.cipher.view.TextCipherView;


public class TextEncryptController implements ICipherController<String> {

    private String encryption;
    private TextCipherView textCipherView;
    private Context context;

    public TextEncryptController(TextCipherView textCipherView, Context context) {
        this.textCipherView = textCipherView;
        this.context = context;

    }


    @Override
    public void onAction(String password, String text) {
        TextEncryptAes textEncryptAes = new TextEncryptAes(password, text);
        textEncryptAes.Encrypt();
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
            this.encryption = textEncryptAes.getCipher();
    }

    public String getEncryption() {
        return encryption;
    }
}
