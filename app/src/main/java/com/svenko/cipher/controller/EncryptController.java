package com.svenko.cipher.controller;

import com.svenko.cipher.model.modes.AesEncrypt;
import com.svenko.cipher.view.CipherView;
import com.svenko.cipher.view.ICipherView;

public class EncryptController implements ICipherController {

    private String encryption;
    CipherView cipherView;

    public EncryptController(CipherView cipherView) {
        this.cipherView = cipherView;
    }

    @Override
    public void onAction(String password, String text) {
        AesEncrypt aesEncrypt=new AesEncrypt(password,text);
        aesEncrypt.Encrypt();
        this.encryption=aesEncrypt.getCipher();
    }

    public String getEncryption() {
        return encryption;
    }
}
