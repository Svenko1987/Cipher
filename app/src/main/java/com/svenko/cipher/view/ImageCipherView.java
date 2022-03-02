package com.svenko.cipher.view;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.svenko.cipher.ImageEncryptionActivity;
import com.svenko.cipher.controller.ImageDecryptController;
import com.svenko.cipher.controller.ImageEncryptionController;
import com.svenko.cipher.model.modes.ImageEncryptAes;

public class ImageCipherView implements ICipherView{
    private TextView passwordTV;
    private ImageView imageIV;
    private Bitmap bitmap;
    private Context context;

    ImageEncryptionController imageEncryptionController;
    ImageDecryptController imageDecryptController;

    public ImageCipherView(TextView passwordTV, ImageView imageIV, Context context) {
        this.passwordTV = passwordTV;
        this.imageIV = imageIV;
        this.context = context;


    }
    public void createBitmap(ImageView imageView){
        this.imageIV.invalidate();
        //BitmapDrawable drawable = (BitmapDrawable) this.imageIV.getDrawable();
        this.bitmap =((BitmapDrawable) imageView.getDrawable()).getBitmap();
    }


    @Override
    public void OnEncrypt() {

        imageEncryptionController= new ImageEncryptionController(this.bitmap, this.context );
        Log.d(TAG, "OnEncrypt: napravljen IEC");
        imageEncryptionController.onAction(passwordTV.getText().toString(),this.bitmap);
        Log.d(TAG, "OnEncrypt: Slika je  encriptovana");
        this.bitmap=imageEncryptionController.getBitmap();
        Log.d(TAG, "OnEncrypt: Slika je postavljena u bitmap");
        imageIV.setImageBitmap(this.bitmap);
        Log.d(TAG, "OnEncrypt: slika stavita na view");

    }

    @Override
    public void OnDecrypt() {

        imageEncryptionController.test();
    }

    @Override
    public void OnError() {

    }
}
