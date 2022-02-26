package com.svenko.cipher.model.modes;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Build;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.svenko.cipher.model.SecretKey;
import com.svenko.cipher.model.datamenagment.LoadBytes;
import com.svenko.cipher.model.datamenagment.SaveBytes;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


public class ImageEncryptAes implements IEncrypt<Bitmap> {
    private String password;
    private Bitmap data;
    private Bitmap cipher;
    private Context context;
    private byte[] imageBytes;
    String path;
    private byte[] prvi;private byte[] drugi;
    SecretKey secretKey;

    public ImageEncryptAes(String password, Bitmap data, Context context) {
        this.password = password;
        this.data = data;
        this.context = context;
    }

    public void ImageToFile() {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.PNG, 100, bas);
        byte[] bytes1 = bas.toByteArray();
        SaveBytes bytes = new SaveBytes(this.context);
        bytes.saveData(bytes1);
        this.path=bytes.getPath();
        this.prvi=bytes1;
    }



    public void FileToImage() throws IOException {
        LoadBytes bytes = new LoadBytes(context);
        this.imageBytes = bytes.normalizeData(new File("/data/data/com.svenko.cipher/files/temp.cph"));
        this.drugi=imageBytes;
        if (prvi==drugi){
        this.cipher = BitmapFactory.decodeByteArray(this.imageBytes, 0, this.imageBytes.length);
        
        if (this.cipher!=null)
            Log.d(TAG, "FileToImage: slika napravljenaj");
        else
            Log.d(TAG, "FileToImage: Nema slike");}
        else Log.d(TAG, "FileToImage: NISU ISTI BITI");

/*        LoadBytes bytes=new LoadBytes(context);
        this.cipher = BitmapFactory.decodeByteArray(bytes.loadData(), 0, bytes.loadData().length);*/


    }



    @Override
    public Bitmap getCipher() {
        return this.cipher;
    }


    @Override
    public void Encrypt() {
        ImageToFile();




/*
        this.secretKey = new SecretKey(password);
        SecretKeySpec keySpec = secretKey.getSecretKey();
        byte[] encVal = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            encVal = cipher.doFinal(this.string.getBytes());
        } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        this.string= Base64.encodeToString(encVal, Base64.DEFAULT);
        FileToImage();
      ByteArrayOutputStream stream= new ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] bytes= stream.toByteArray();
        this.secretKey = new SecretKey(password);
        SecretKeySpec keySpec = secretKey.getSecretKey();
        byte[] encVal = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            encVal = cipher.doFinal(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        String imageEncoded = Base64.encodeToString(encVal, Base64.DEFAULT);
        byte[] decodedByte = Base64.decode(imageEncoded, 0);

        this.cipher= BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);*/

    }
    public void Test(){
        try {
            FileToImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
