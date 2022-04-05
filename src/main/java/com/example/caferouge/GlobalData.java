package com.example.caferouge;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//GlobalData.orders
public class GlobalData {

    static ArrayList<Dish> dishes=new ArrayList<Dish>();
    static Map<String, String> dishesURL=new HashMap<String, String>();
    static ArrayList<Dish> dishesTemp=new ArrayList<Dish>();
    //the current Order will always be the last one
    static ArrayList<Order> orders=new ArrayList<Order>();
    //currentOrder=GlobalData.orders.get(GlobalData.orders.size()-1)
    //currentOrder.dishes
    //login user=new User();
    static User user;

}

