package com.example.mentalcountingg.services;

import com.example.mentalcountingg.models.ResFaux;
import com.example.mentalcountingg.models.ResVide;


public class Verification {

    private int correctResultat;//vrai résultat

    public void Verification(int resUtilInt, int res) throws ResFaux, ResVide {
        correctResultat=res;
        if (correctResultat == resUtilInt) {
            return;
        }
        else
        {
            throw new ResFaux("Faux");
        }
    }

    public int getCorrectRes() {
        return correctResultat;
    }

}
