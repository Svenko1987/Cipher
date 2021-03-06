package com.svenko.cipher;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.svenko.cipher.view.ImageCipherView;

public class ImageEncryptionActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_encryption);

        Button switchBtn = findViewById(R.id.textBtn);
        Button encryptBtn = findViewById(R.id.encryptBtn2);
        Button decryptBtn = findViewById(R.id.decryptBtn2);

        TextView passwordTV = findViewById(R.id.keyTF2);
        ImageView imageView =findViewById(R.id.imageIV);
        ImageCipherView imageCipherView = new ImageCipherView(passwordTV, imageView, ImageEncryptionActivity.this);

        Button cameraBtn = findViewById(R.id.cameraBtn);


        switchBtn.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        if (ContextCompat.checkSelfPermission(ImageEncryptionActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ImageEncryptionActivity.this, new String[]{Manifest.permission.CAMERA}, 100);
        }
        cameraBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
        });
        encryptBtn.setOnClickListener(view -> {
            if (imageView.getDrawable() == null){
                Toast.makeText(ImageEncryptionActivity.this, "No image", Toast.LENGTH_SHORT).show();
            }else{


                imageCipherView.createBitmap(imageView);
                imageCipherView.OnEncrypt();
            }
        });
        decryptBtn.setOnClickListener(view -> {
            imageCipherView.OnDecrypt();
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");

            ImageView imageView = findViewById(R.id.imageIV);
            imageView.setImageBitmap(capturedImage);
        }
    }


}