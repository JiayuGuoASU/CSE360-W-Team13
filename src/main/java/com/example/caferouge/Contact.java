package com.example.caferouge;
//by Boyang, 03/29

public class Contact {

    public String phoneNumber;

    public String address;

    public Contact(String phoneNumber, String address){

        this.phoneNumber = phoneNumber;

        this.address = address;

    }

    public void editPhoneNumber(String inputPhoneH){

        phoneNumber = inputPhoneH;

    }
    public void editAddress(String inputAddr){

        address = inputAddr;

    }
}
