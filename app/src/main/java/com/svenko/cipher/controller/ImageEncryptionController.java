package com.svenko.cipher.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.svenko.cipher.model.modes.ImageEncryptAes;
import com.svenko.cipher.view.ImageCipherView;

import java.io.ByteArrayOutputStream;

public class ImageEncryptionController implements ICipherController<Bitmap>{

    private Bitmap bitmap;
   // private ImageCipherView cipherView;
    private Context context;

    public ImageEncryptionController(Bitmap bitmap) {
        this.bitmap = bitmap;
        //this.cipherView = cipherView;
       // this.context = context;
    }

    @Override
    public void onAction(String password, Bitmap bitmap) {
        ImageEncryptAes encryptAes= new ImageEncryptAes(password,bitmap);
        encryptAes.Encrypt();
      //  if (password.equals(""))
         //   Toast.makeText(context, "Enter Password", Toast.LENGTH_SHORT).show();
       // else if (bitmap.equals(""))
         //   Toast.makeText(context, "Get Picture", Toast.LENGTH_SHORT).show();
       // else
        this.bitmap=encryptAes.getCipher();

    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
