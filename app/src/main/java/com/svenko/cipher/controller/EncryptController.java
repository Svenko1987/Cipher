package com.svenko.cipher.controller;

import com.svenko.cipher.model.modes.AesEncrypt;
import com.svenko.cipher.view.ICipherView;

public class EncryptController implements ICipherController {

    private String encryption;
    ICipherView iCipherView;

    public EncryptController(ICipherView iCipherView) {
        this.iCipherView = iCipherView;
    }

    @Override
    public void onAction(String password, String text) {
        AesEncrypt aesEncrypt=new AesEncrypt(password,text);
        aesEncrypt.Encrypt();
        this.encryption=aesEncrypt.getCipher();
    }
}