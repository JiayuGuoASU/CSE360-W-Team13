package com.example.caferouge;

//by Boyang, 03/29


public class Payment {
    public String cardNum;

    public String cardHolderName;

    public Payment(String cardNum, String cardHolderName){

        this.cardNum = cardNum;

        this.cardHolderName = cardHolderName;

    }

    public void editcardNum(String inputcardName){

        cardNum = inputcardName;

    }
    public void editcardHolderName(String inputcardHolderName){

        cardHolderName = inputcardHolderName;

    }
}
