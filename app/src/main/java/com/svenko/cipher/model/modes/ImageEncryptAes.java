package com.svenko.cipher.model.modes;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.svenko.cipher.model.SecretKey;

import java.io.ByteArrayOutputStream;
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
    private String string;
    private byte[] imageBytes;
    SecretKey secretKey;

    public ImageEncryptAes(String password, Bitmap data) {
        this.password = password;
        this.data = data;
    }

    public void ImageToString(){
        ByteArrayOutputStream bas=new  ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.PNG,100, bas);
        byte [] b=bas.toByteArray();

        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        Log.d(TAG, "ImageToString: " + temp);
        this.string = temp;

    }

    public void StringToImage() {
        try {
            byte[] encodeByte = Base64.decode(this.string, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            this.cipher = bitmap;
            Log.d(TAG, "StringToImage: String je dekodiran u sliku");
        } catch (Exception e) {
            e.getMessage();


        }
    }


    @Override
    public Bitmap getCipher() {
        return this.cipher;
    }

    @Override


    public void Encrypt() {
        ImageToString();


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
        StringToImage();
/*        ByteArrayOutputStream stream= new ByteArrayOutputStream();
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
}
