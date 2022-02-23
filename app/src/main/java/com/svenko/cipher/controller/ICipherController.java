package com.svenko.cipher.controller;

public interface ICipherController <T> {
    void onAction(String password, T t);
}
