package com.svenko.cipher.controller;

import android.content.Context;
import android.widget.Toast;

import com.svenko.cipher.model.modes.AesEncrypt;
import com.svenko.cipher.view.CipherView;

// todo: Encrypt-/DecryptController bih sastavio u jednu singleton klasu. Nema potrebe da budu dvije.
public class EncryptController implements ICipherController {

    private String encryption;
    // todo: Ovo polje krši MVC.
    CipherView cipherView;
    Context context;

    public EncryptController(CipherView cipherView, Context context) {
        this.cipherView = cipherView;
        this.context=context;
    }

    @Override
    public void onAction(String password, String text) {
        AesEncrypt aesEncrypt=new AesEncrypt(password,text);
        aesEncrypt.Encrypt();
        // todo: if (password.isEmpty()) {...}
        // todo: vitičaste zagrade su bitne za čitljivost
        if (password.equals(""))
            Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
            // todo: if (text.isEmpty()) {...}
        else if (text.equals(""))
            Toast.makeText(context, "Enter Message", Toast.LENGTH_SHORT).show();
        else
        this.encryption=aesEncrypt.getCipher();
    }

    public String getEncryption() {
        // todo: potencijalni NPE
        return encryption;
    }
}
