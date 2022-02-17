package com.svenko.cipher.controller;

// todo: Ovi interfacei su uglavnom beskorisni. Svakako ne koristiš polimorfizam.
public interface ICipherController {
    void onAction(String password, String text);
}
