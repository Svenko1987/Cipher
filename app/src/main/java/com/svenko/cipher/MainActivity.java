package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import com.svenko.cipher.view.ICipherView;

public class MainActivity extends AppCompatActivity implements ICipherView {

    Button encryptBtn, decryptBtn;
    TextView passwordTV, textTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encryptBtn=findViewById(R.id.encryptBtn);
        decryptBtn=findViewById(R.id.decryptBtn);
        passwordTV=findViewById(R.id.keyTF);
        textTV=findViewById(R.id.textTV);


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