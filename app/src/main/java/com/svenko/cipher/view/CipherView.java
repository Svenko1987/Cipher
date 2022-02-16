package com.svenko.cipher.view;

import android.widget.Button;
import android.widget.TextView;

import com.svenko.cipher.controller.DecryptController;
import com.svenko.cipher.controller.EncryptController;

public class CipherView implements ICipherView{
    private Button encryptBtn, decryptBtn;
    private TextView passwordTV, textTV;
    DecryptController decryptController;
    EncryptController encryptController;

    public CipherView(Button encryptBtn, Button decryptBtn, TextView passwordTV, TextView textTV) {
        this.encryptBtn = encryptBtn;
        this.decryptBtn = decryptBtn;
        this.passwordTV = passwordTV;
        this.textTV = textTV;
    }

    @Override
    public void OnEncrypt(String encryption) {
        encryptController=new EncryptController(this);
        encryptController.onAction(passwordTV.getText().toString(),textTV.getText().toString());
        textTV.setText(encryptController.getEncryption());

    }

    @Override
    public void OnDecrypt(String decryption) {
        decryptController= new DecryptController(this);

        decryptController.onAction(passwordTV.getText().toString(),textTV.getText().toString());
        textTV.setText(decryptController.getDecryption());


    }

    @Override
    public void OnError(String errorMessage) {

    }
}
