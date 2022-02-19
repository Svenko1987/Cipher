package com.svenko.cipher.view;

import android.content.Context;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;


import com.svenko.cipher.controller.DecryptController;
import com.svenko.cipher.controller.EncryptController;

public class TextCipherView implements ICipherView {
    private TextView passwordTV, textTV;
    DecryptController decryptController;
    EncryptController encryptController;
    Context context;

    public TextCipherView(TextView passwordTV, TextView textTV, Context context) {
        this.passwordTV = passwordTV;
        this.textTV = textTV;
        this.context = context;
    }


    @Override
    public void OnEncrypt() {
        encryptController = new EncryptController(this, this.context);
        encryptController.onAction(passwordTV.getText().toString(), textTV.getText().toString());
        passwordTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.setText(encryptController.getEncryption());

    }

    @Override
    public void OnDecrypt() {
        decryptController = new DecryptController(this, this.context);
        decryptController.onAction(passwordTV.getText().toString(), textTV.getText().toString());
        passwordTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.setText(decryptController.getDecryption());
    }

    @Override
    public void OnError() {

    }
}
