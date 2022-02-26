package com.svenko.cipher.model.datamenagment;

import java.io.File;
import java.io.IOException;

public interface ILoadData <T>{
    T normalizeData(File file) throws IOException;
    T loadData();
}
