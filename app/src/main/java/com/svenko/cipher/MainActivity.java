package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.svenko.cipher.view.TextCipherView;


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


        TextCipherView textCipherView =new TextCipherView(passwordTV,textTV,this);

        encryptBtn.setOnClickListener(v -> textCipherView.OnEncrypt());
        decryptBtn.setOnClickListener(v -> textCipherView.OnDecrypt());


    }

}