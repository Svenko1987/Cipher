package com.svenko.cipher.model.datamenagment;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class SaveBytes implements ISaveData<byte[]>{
    private Context context;
    private String path;

    public SaveBytes(Context context) {
        this.context = context;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void normalizeData() {

    }

    @Override
    public void saveData(byte[] bytes) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream= context.openFileOutput("temp.cph",Context.MODE_PRIVATE);
            fileOutputStream.write(bytes);
            Log.d(TAG, "saveData: Saved to memory "+context.getFilesDir());
            this.path=context.getFilesDir()+"/"+"temp.chp";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream !=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



/*        File outputDir = context.getCacheDir(); // context being the Activity pointer
        try {
            File outputFile = File.createTempFile("temp", ".cph", outputDir);
            Log.d(TAG, "saveData: slika je sacuvana u cache");
            return outputFile;
 
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "saveData: Slika je sacuvana u cache");
            return null;
        }*/


    }
}
