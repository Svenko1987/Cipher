package com.svenko.cipher.view;

import android.content.Context;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;


import com.svenko.cipher.controller.TextDecryptController;
import com.svenko.cipher.controller.TextEncryptController;

public class TextCipherView implements ICipherView {
    private TextView passwordTV, textTV;
    TextDecryptController textDecryptController;
    TextEncryptController textEncryptController;
    Context context;

    public TextCipherView(TextView passwordTV, TextView textTV, Context context) {
        this.passwordTV = passwordTV;
        this.textTV = textTV;
        this.context = context;
    }


    @Override
    public void OnEncrypt() {
        textEncryptController = new TextEncryptController(this, this.context);
        textEncryptController.onAction(passwordTV.getText().toString(), textTV.getText().toString());
        passwordTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.setText(textEncryptController.getEncryption());

    }

    @Override
    public void OnDecrypt() {
        textDecryptController = new TextDecryptController(this, this.context);
        textDecryptController.onAction(passwordTV.getText().toString(), textTV.getText().toString());
        passwordTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.onEditorAction(EditorInfo.IME_ACTION_DONE);
        textTV.setText(textDecryptController.getDecryption());
    }

    @Override
    public void OnError() {

    }
}
