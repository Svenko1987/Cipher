package com.svenko.cipher.model.datamenagment;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;

import android.util.Log;


import java.io.BufferedInputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoadBytes implements ILoadData<byte[]> {
    private Context context;


    public LoadBytes(Context context) {
        this.context = context;
    }




    @Override
    public byte[] normalizeData(File file) throws IOException {
        int size = (int) file.length();
        byte bytes[] = new byte[size];
        byte tmpBuff[] = new byte[size];
        FileInputStream fis= new FileInputStream(file);;
        try {

            int read = fis.read(bytes, 0, size);
            if (read < size) {
                int remain = size - read;
                while (remain > 0) {
                    read = fis.read(tmpBuff, 0, remain);
                    System.arraycopy(tmpBuff, 0, bytes, size - remain, read);
                    remain -= read;
                }
            }
        }  catch (IOException e){
            throw e;
        } finally {
            fis.close();
        }
        return bytes;
    }


    @Override
    public byte[] loadData() {
        return null;
/*
        byte[] bytes=null;
        FileInputStream fileInputStream=null;
        try {
            fileInputStream= context.openFileInput("temp.cph");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            bytes=inputStreamReader.re
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




            File file = new File("temp.cph");
            int size = (int) file.length();
            byte[] bytes = new byte[size];
        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bytes,0,bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bytes!=null)
            Log.d(TAG, "loadData: bytes loaded");
        else
            Log.d(TAG, "loadData: bytes not loaded");
        return bytes;*/

/*            fileInputStream= context.openFileInput("temp.cph");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);*/

/*        File cacheFile = new File(context.getCacheDir(), "temp.chp");

        byte[] data=null;
        try {
            data = Files.readAllBytes(cacheFile.toPath());
            Log.d(TAG, "normalizeData: File converted to bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;*/






    }
}
