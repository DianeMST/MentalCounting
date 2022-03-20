package com.example.mentalcountingg.models;

public class ResFaux extends Exception {
    public ResFaux(String message){
        super(message);
    }
    public ResFaux(String message, Throwable innerException){
        super(message, innerException);
    }
}
