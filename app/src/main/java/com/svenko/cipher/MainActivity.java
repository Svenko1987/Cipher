package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.svenko.cipher.controller.DecryptController;
import com.svenko.cipher.controller.EncryptController;
import com.svenko.cipher.view.ICipherView;

public class MainActivity extends AppCompatActivity implements ICipherView {

    Button encryptBtn, decryptBtn;
    TextView passwordTV, textTV;
    DecryptController decryptController;
    EncryptController encryptController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encryptBtn=findViewById(R.id.encryptBtn);


    }

    @Override
    public void OnEncrypt(String encryption) {

    }

    @Override
    public void OnDecrypt(String decryption) {

    }

    @Override
    public void OnError(String errorMessage) {

    }
}