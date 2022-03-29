package com.example.caferouge;
//by Boyang, 03/29

public class Coupons {

    public double discount;

    public void changeDiscount(Order inputOrder){

        inputOrder.amount = inputOrder.amount * discount;

    }
}
