package com.example.caferouge;

//by Boyang, 03/29


public class Manager extends User{

    public Manager(String name, String pwd, int type){
        super(name, pwd, type);

    }

    public void giveCoupons(){

    }
    public void addNewItemToMenu(String addName, double addPrice, double addTime){
        
        Dish dish = new Dish(addName,addPrice,addTime);
        
        dish.giveName(addName);
        
        dish.setPrice(addPrice);
        
        dish.setTime(addTime);

    }
    public void removeDish(){

    }

}
