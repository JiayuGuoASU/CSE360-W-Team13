package com.example.caferouge;

import java.util.LinkedList;

//by Boyang, 03/29

public class Order {

    public LinkedList<Dish> dishes;

    public LinkedList<Integer> quantityOfDish;

    public double amount;

    public double cookingTime;

    public double orderTime;

    public User user;

    public void calculateCookingTime(){

        orderTime = 0;

        for(int i = 0; i < dishes.size(); i++){

            orderTime = orderTime + dishes.get(i).time;

        }

    }

    public void setQuantityOfDish(int inputQuantity){

        int index =0;

        //TODO add dish to Order, Order implement::setQuantityOfDish

        //find the dish and get index
        //use quantityOfDish.


        quantityOfDish.set(index, inputQuantity);

    }

}
