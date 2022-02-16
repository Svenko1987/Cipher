package com.svenko.cipher.controller;

import com.svenko.cipher.model.modes.AesDecrypt;
import com.svenko.cipher.view.ICipherView;

public class DecryptController implements ICipherController {

    private String decryption;
    ICipherView iCipherView;

    public DecryptController(ICipherView iCipherView) {
        this.iCipherView = iCipherView;
    }

    @Override
    public void onAction(String password, String text) {
        AesDecrypt aesDecrypt=new AesDecrypt(password,text);
        aesDecrypt.decrypt();

        this.decryption=aesDecrypt.getText();
    }
}
