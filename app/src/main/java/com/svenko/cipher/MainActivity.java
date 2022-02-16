package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.svenko.cipher.view.CipherView;
import com.svenko.cipher.view.ICipherView;

public class MainActivity extends AppCompatActivity {

    Button encryptBtn, decryptBtn;
    TextView passwordTV, textTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encryptBtn=findViewById(R.id.encryptBtn);
        decryptBtn=findViewById(R.id.decryptBtn);
        passwordTV=findViewById(R.id.keyTF);
        textTV=findViewById(R.id.messageTF);


        CipherView cipherView =new CipherView(encryptBtn,decryptBtn,passwordTV,textTV);

        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cipherView.OnEncrypt();
            }
        });
        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cipherView.OnDecrypt();
            }
        });


    }

}