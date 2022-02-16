package com.svenko.cipher.controller;

import com.svenko.cipher.model.modes.AesDecrypt;
import com.svenko.cipher.view.CipherView;
import com.svenko.cipher.view.ICipherView;

public class DecryptController implements ICipherController {

    private String decryption;
    CipherView cipherView;

    public DecryptController(CipherView cipherView) {
        this.cipherView = cipherView;
    }

    @Override
    public void onAction(String password, String text) {
        AesDecrypt aesDecrypt=new AesDecrypt(password,text);
        aesDecrypt.decrypt();

        this.decryption=aesDecrypt.getText();

    }

    public String getDecryption() {
        return decryption;
    }
}
