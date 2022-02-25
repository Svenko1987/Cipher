package com.svenko.cipher.model.datamenagment;

import android.content.Context;

import java.io.File;
import java.io.IOException;


public class SaveBytes implements ISaveData<byte[]>{
    Context context;

    public SaveBytes(Context context) {
        this.context = context;
    }

    @Override
    public void normalizeData(byte[] bytes) {

    }

    @Override
    public File saveData(byte[] bytes) {
        File outputDir = context.getCacheDir(); // context being the Activity pointer
        try {
            File outputFile = File.createTempFile("temp", ".cph", outputDir);
            return outputFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
