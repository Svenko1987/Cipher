package com.svenko.cipher.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.TextView;

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

    public ImageCipherView(TextView passwordTV, ImageView imageIV) {
        this.passwordTV = passwordTV;
        this.imageIV = imageIV;
        //this.context = context;
        CreateBitmap();

    }
    private void CreateBitmap(){
        this.imageIV.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) this.imageIV.getDrawable();
        this.bitmap = drawable.getBitmap();
    }

    @Override
    public void OnEncrypt() {

        imageEncryptionController= new ImageEncryptionController(bitmap);
        imageEncryptionController.onAction(passwordTV.getText().toString(),bitmap);
        this.bitmap=imageEncryptionController.getBitmap();
        imageIV.setImageBitmap(this.bitmap);

    }

    @Override
    public void OnDecrypt() {

    }

    @Override
    public void OnError() {

    }
}
