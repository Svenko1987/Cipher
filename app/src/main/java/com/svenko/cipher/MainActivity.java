package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;



import com.svenko.cipher.view.CipherView;


public class MainActivity extends AppCompatActivity {

    // todo: Ukloni nepotrebna polja.
    Button encryptBtn, decryptBtn;
    TextView passwordTV, textTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // todo: Ukloni nepotrebne promjenjive.
        encryptBtn=findViewById(R.id.encryptBtn);
        decryptBtn=findViewById(R.id.decryptBtn);
        passwordTV=findViewById(R.id.keyTF);
        textTV=findViewById(R.id.messageTF);

        // todo: Umjesto promjenjivih, proslijedi findViewById(...).
        CipherView cipherView =new CipherView(encryptBtn,decryptBtn,passwordTV,textTV,this);
        // todo: Ove linije krše MVC. CipherView svakako dobija encrypt-/decryptBtn. Neka CipherView riješi onclick.
        encryptBtn.setOnClickListener(v -> cipherView.OnEncrypt());
        decryptBtn.setOnClickListener(v -> cipherView.OnDecrypt());


    }

}