package com.svenko.cipher.model.datamenagment;

import java.io.File;

public interface ISaveData <T>{
    void normalizeData();
    void saveData(T t);

}
