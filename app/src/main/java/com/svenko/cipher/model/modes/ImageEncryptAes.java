package com.svenko.cipher.model.modes;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.Log;


import com.svenko.cipher.model.SecretKey;
import com.svenko.cipher.model.datamenagment.LoadBytes;
import com.svenko.cipher.model.datamenagment.SaveBytes;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class ImageEncryptAes implements IEncrypt<Bitmap> {
    private String password;
    private Bitmap data;
    private Bitmap cipher;
    private Context context;
    private byte[] imageBytes;
    String path="/data/data/com.svenko.cipher/files/test.cph";
    private byte[] prvi=null;
    private byte[] drugi=null;
    private String a="";
    private String b="";
    SecretKey secretKey;

    public ImageEncryptAes(String password, Bitmap data, Context context) {
        this.password = password;
        this.data = data;
        this.context = context;
    }

    public void saveImage()  {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.PNG, 100, bas);
        byte[] bytes = bas.toByteArray();
        String data= new String(bytes, StandardCharsets.UTF_8);
        Log.d(TAG, "saveImage: data je"+data);

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            this.a=data;
            Log.d(TAG, "saveImage: SACUVANO");
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }



    }

    void loadImage() {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                b=ret;
                Log.d(TAG, "loadImage: PREUZETO");
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        try {
            byte[] bytes = ret.getBytes("UTF-8");
            this.cipher = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }








    }

    public void ImageToFile() {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.PNG, 100, bas);
        byte[] bytes1 = bas.toByteArray();
        SaveBytes bytes = new SaveBytes(this.context);
        bytes.saveData(bytes1);
        Log.d(TAG, "ImageToFile: "+bytes1.toString());
        this.path = bytes.getPath();
        this.prvi = bytes1;
    }


    public void FileToImage() throws IOException {
        LoadBytes bytes = new LoadBytes(context);
        this.imageBytes = bytes.normalizeData(new File(path));
        this.drugi = imageBytes;
        if (Arrays.equals(prvi, drugi)) {
            this.cipher = BitmapFactory.decodeByteArray(this.imageBytes, 0, this.imageBytes.length);

            if (this.cipher != null)
                Log.d(TAG, "FileToImage: slika napravljenaj");
            else
                Log.d(TAG, "FileToImage: Nema slike");
        } else Log.d(TAG, "FileToImage: NISU ISTI BITI");

/*        LoadBytes bytes=new LoadBytes(context);
        this.cipher = BitmapFactory.decodeByteArray(bytes.loadData(), 0, bytes.loadData().length);*/


    }


    @Override
    public Bitmap getCipher() {
        return this.cipher;
    }


    @Override
    public void Encrypt() {
        saveImage();




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

    public void Test() {
        loadImage();
        if (this.a.equals(this.b))
            Log.d(TAG, "Encrypt: ISTI SU");
        else
            Log.d(TAG, "Encrypt: NISU ISTI b je"+this.b);


    }

}
