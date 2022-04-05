package com.example.caferouge;

//by Boyang, 03/29


public class Manager extends User{

    public Manager(String name, String pwd, String type){
        super(name, pwd, type);

    }

    public void giveCoupons(){

    }
    public void addNewItemToMenu(String addName, double addPrice, double addTime, String des){
        
        Dish dish = new Dish(addName,addPrice,addTime, des);
        
        dish.giveName(addName);
        
        dish.setPrice(addPrice);
        
        dish.setTime(addTime);

    }
    public void removeDish(){

    }

}
