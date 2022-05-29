package com.svenko.cipher.model.data;

public class Message {
    private String text;
    private boolean encrypted;

    public Message(String text, boolean encrypted) {
        this.text = text;
        this.encrypted = encrypted;
    }

    public Message() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }
}
