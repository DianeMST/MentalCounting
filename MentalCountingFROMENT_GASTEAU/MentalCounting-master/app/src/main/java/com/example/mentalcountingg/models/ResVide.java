package com.example.mentalcountingg.models;

public class ResVide extends Exception {
    public ResVide(String message){
        super(message);
    }
    public ResVide(String message, Throwable innerException){
        super(message, innerException);
    }

}
