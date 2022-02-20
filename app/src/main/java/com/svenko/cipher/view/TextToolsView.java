package com.svenko.cipher.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.widget.TextView;
import android.widget.Toast;


public class TextToolsView implements IToolsView {
    private TextView passwordTV, textTV;

    Context context;
    ClipboardManager clipboardManager;


    public TextToolsView(TextView passwordTV, TextView textTV, Context context, ClipboardManager clipboardManager) {
        this.passwordTV = passwordTV;
        this.textTV = textTV;
        this.context = context;
        this.clipboardManager=clipboardManager;



    }


    @Override
    public void showHidePassword() {
        if (this.passwordTV.getTransformationMethod() != null) {
            this.passwordTV.setTransformationMethod(null);
        } else {
            this.passwordTV.setTransformationMethod(new PasswordTransformationMethod());
        }
    }


    @Override
    public void copyDataToClipboard() {



    }

    @Override
    public void pasteDataFromClipboard() {


    }

    @Override
    public Intent shareData() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBody = textTV.getText().toString();
        intent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
        intent.putExtra(Intent.EXTRA_TEXT, shareBody);

        return intent;

    }

    @Override
    public void clearData() {
        this.passwordTV.setText("");
        this.textTV.setText("");

    }
}
