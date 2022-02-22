package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.svenko.cipher.view.TextCipherView;
import com.svenko.cipher.view.TextToolsView;


public class MainActivity extends AppCompatActivity {

    Button encryptBtn, decryptBtn, showHideBtn, clearBtn, copyBtn, pasteBtn, shareBtn,switchBtn;
    TextView passwordTV, textTV;


    ClipboardManager clipboardManager;


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
        switchBtn=findViewById(R.id.switchToImageBtn);

        passwordTV=findViewById(R.id.keyTF);
        textTV=findViewById(R.id.messageTF);

        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);


        TextCipherView textCipherView =new TextCipherView(passwordTV,textTV,this);
        TextToolsView textToolsView = new TextToolsView(passwordTV,textTV,this, clipboardManager);

        encryptBtn.setOnClickListener(v -> textCipherView.OnEncrypt());
        decryptBtn.setOnClickListener(v -> textCipherView.OnDecrypt());
        showHideBtn.setOnClickListener(v -> textToolsView.showHidePassword());
        clearBtn.setOnClickListener(v -> textToolsView.clearData());
        copyBtn.setOnClickListener(v -> textToolsView.copyDataToClipboard());
        pasteBtn.setOnClickListener(v -> textToolsView.pasteDataFromClipboard());


        shareBtn.setOnClickListener(v -> {
            if (textTV.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Text field is empty", Toast.LENGTH_SHORT).show();
            } else {
            startActivity(Intent.createChooser(textToolsView.shareData(), "Share using"));
        }});
        switchBtn.setOnClickListener(v -> {

            try {
                Intent intent=new Intent(getApplicationContext(), ImageEncryptionActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });




    }

}