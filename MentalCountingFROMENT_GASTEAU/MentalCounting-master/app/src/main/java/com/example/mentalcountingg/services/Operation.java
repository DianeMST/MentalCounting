package com.example.mentalcountingg.services;

import java.util.Random;

public class Operation {

    private int nb1;
    private int nb2;
    private String operateur;
    private int resultat;



    public int Aleatoire(){

        Random random = new Random();
        int operator = random.nextInt(3);
        nb1 = random.nextInt(10);
        nb2 = random.nextInt(10);


        switch (operator){
            case 0:
                operateur = "+";
                resultat = nb1+nb2;
                CorrectOpe();
                break;
            case 1:
                operateur = "-";
                resultat = nb1-nb2;
                CorrectOpe();
                break;
            case 2:
                operateur = "*";
                resultat = nb1*nb2;
                CorrectOpe();
                break;
            default:
                Aleatoire();
        }
        return resultat;
    }

    public boolean CorrectOpe(){
        return true;
    }

    public int getnb1() {
        return nb1;
    }

    public int getnb2() {return nb2;}

    public String getOperateur() {
        return operateur;
    }

}
