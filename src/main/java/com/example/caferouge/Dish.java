package com.example.caferouge;

//by Boyang, 03/29

public class Dish {

    public String dishName;
    public double price;
    public double time;

    public Dish(String dishName, double price, double time){

        this.dishName = dishName;

        this.price = price;

        this.time = time;

    }

    public void giveName(String inputName){

        dishName = inputName;

    }
    public void setPrice(double inputPrice){

        price = inputPrice;

    }
    public void setTime(double inputTime){

        time = inputTime;

    }

}
