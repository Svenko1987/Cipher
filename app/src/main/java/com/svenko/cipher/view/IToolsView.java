package com.svenko.cipher.view;

import android.content.Intent;
import android.widget.Button;

public interface IToolsView {
    void showHidePassword();
    void copyDataToClipboard();
    void pasteDataFromClipboard();
    Intent shareData();
    void clearData();

}
