package com.svenko.cipher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import android.widget.Button;
import android.widget.ImageView;

public class ImageEncryptionActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_encryption);

        Button switchBtn=findViewById(R.id.textBtn);

        imageView=(ImageView)findViewById(R.id.imageIV);

        Button cameraBtn=findViewById(R.id.cameraBtn);

        switchBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
        if (ContextCompat.checkSelfPermission(ImageEncryptionActivity.this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ImageEncryptionActivity.this, new String[]{Manifest.permission.CAMERA},100);
        }
        cameraBtn.setOnClickListener(v -> {
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,100);
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(capturedImage);
        }
    }
}