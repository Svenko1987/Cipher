package com.svenko.cipher.controller;

import com.svenko.cipher.model.AesEncrypt;
import com.svenko.cipher.view.ICipherView;

public class DecryptController implements ICipherController {

    ICipherView iCipherView;

    public DecryptController(ICipherView iCipherView) {
        this.iCipherView = iCipherView;
    }

    @Override
    public void OnEncryption(String password, String text) {
        AesEncrypt aesEncrypt=new AesEncrypt(password,text);
        aesEncrypt.Encrypt();

        iCipherView.OnEncrypt(aesEncrypt.getText());
    }
}
