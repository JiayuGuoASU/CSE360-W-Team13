package com.example.caferouge;

import java.util.LinkedList;

//by Boyang, 03/29

public class Customer extends Browser{

    public Contact contact;
    public Payment payment;
    public LinkedList<Order> orderHistory;
    public LinkedList<Coupons> CouponList;

    public Customer(String name, String pwd, int type, Order browOrder,Contact contact,Payment payment,LinkedList<Order> orderHistory,LinkedList<Coupons> CouponList){

        super(name,pwd,type,browOrder);

        this.contact = contact;

        this.payment = payment;

        this.orderHistory = orderHistory;

        this.CouponList = CouponList;

    }

    public void editProfile(){


    }
    public void newOrder(){


    }
    public void checkOut(){


    }

}
