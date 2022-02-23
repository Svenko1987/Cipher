package com.svenko.cipher.controller;

import android.content.Context;
import android.graphics.Bitmap;

import com.svenko.cipher.view.ImageCipherView;

public class ImageEncryptionController implements ICipherController<Bitmap>{

    private Bitmap bitmap;
    private ImageCipherView cipherView;
    private Context context;

    public ImageEncryptionController(Bitmap bitmap, ImageCipherView cipherView, Context context) {
        this.bitmap = bitmap;
        this.cipherView = cipherView;
        this.context = context;
    }

    @Override
    public void onAction(String password, Bitmap bitmap) {

    }
}
