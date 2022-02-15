package com.svenko.cipher.view;

public interface ICipherView {

    void OnEncrypt(String encryption);
    void OnDecrypt(String decryption);
    void OnError(String errorMessage);
}
