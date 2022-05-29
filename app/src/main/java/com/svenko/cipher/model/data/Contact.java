package com.svenko.cipher.model.data;

public class Contact {
    private String name;
    private byte[] key;

    public Contact(String name, byte[] key) {
        this.name = name;
        this.key = key;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getKey() {
        return key;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }
}
