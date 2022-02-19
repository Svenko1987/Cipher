package com.svenko.cipher.view;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.TextView;

import com.svenko.cipher.R;

public class TextToolsView implements IToolsView{
    private TextView passwordTV, textTV;
    Button btn;
    Context context;

    public TextToolsView(TextView passwordTV, TextView textTV, Context context, Button showHideBtn) {
        this.passwordTV = passwordTV;
        this.textTV = textTV;
        this.context = context;
        this.btn.findViewById(R.id.encryptBtn);
        this.btn.setOnClickListener(v -> showHidePassword());
    }
    void onClick(){
        this.btn.setOnClickListener(v -> showHidePassword());
    }

    @Override
    public void showHidePassword() {
        if(!this.passwordTV.getTransformationMethod().equals(null)){
            this.passwordTV.setTransformationMethod(null);
        } else{
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
    public void shareData() {

    }

    @Override
    public void clearData() {

    }
}
