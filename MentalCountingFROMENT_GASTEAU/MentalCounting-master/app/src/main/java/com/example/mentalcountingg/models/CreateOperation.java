package com.example.mentalcountingg.models;

import com.example.mentalcountingg.services.Operation;

public class CreateOperation {
    Operation op = new Operation();
    int nb1;
    int nb2;
    String operateur;

    public String GetOp(){
        this.operateur = op.getOperateur();
        return (operateur);
    }

    public int Getnb1(){
        this.nb1 = op.getnb1();
        return (nb1);
    }

    public int Getnb2(){
        this.nb2 = op.getnb2();
        return (nb2);
    }

}
