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
        this.clipboardManager = clipboardManager;


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
        if (textTV.getText().equals(null)) {
            Toast.makeText(context, "No text to copy", Toast.LENGTH_SHORT).show();
        } else {
            clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("text", textTV.getText().toString());
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void pasteDataFromClipboard() {
        ClipData clipData = clipboardManager.getPrimaryClip();
        ClipData.Item item = clipData.getItemAt(0);
        textTV.setText(item.getText().toString());
        Toast.makeText(context, "Pasted", Toast.LENGTH_SHORT).show();


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
