package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.svenko.cipher.view.TextCipherView;
import com.svenko.cipher.view.TextToolsView;


public class MainActivity extends AppCompatActivity {

    Button encryptBtn, decryptBtn, showHideBtn, clearBtn, copyBtn, pasteBtn, shareBtn;
    TextView passwordTV, textTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        encryptBtn=findViewById(R.id.encryptBtn);
        decryptBtn=findViewById(R.id.decryptBtn);
        showHideBtn=findViewById(R.id.showHideBtn);
        clearBtn=findViewById(R.id.clearBtn);
        copyBtn=findViewById(R.id.copyBTn);
        pasteBtn=findViewById(R.id.pasteBtn);
        shareBtn=findViewById(R.id.shareBtn);

        passwordTV=findViewById(R.id.keyTF);
        textTV=findViewById(R.id.messageTF);


        TextCipherView textCipherView =new TextCipherView(passwordTV,textTV,this);
        TextToolsView textToolsView = new TextToolsView(passwordTV,textTV,this);

        encryptBtn.setOnClickListener(v -> textCipherView.OnEncrypt());
        decryptBtn.setOnClickListener(v -> textCipherView.OnDecrypt());
        showHideBtn.setOnClickListener(v -> textToolsView.showHidePassword());
        clearBtn.setOnClickListener(v -> textToolsView.clearData());
        copyBtn.setOnClickListener(v -> textToolsView.copyDataToClipboard());
        pasteBtn.setOnClickListener(v -> textToolsView.pasteDataFromClipboard());
        shareBtn.setOnClickListener(v -> startActivity(Intent.createChooser(textToolsView.shareData(), "Share using")));




    }

}