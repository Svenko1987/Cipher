package com.svenko.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int prvi;
        int drugi=15;
        prvi=25;
        int treci =prvi+drugi;

        Log.d("Odgovor",String.valueOf(treci));

    }
}