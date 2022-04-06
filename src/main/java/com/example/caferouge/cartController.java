package com.example.caferouge;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class cartController  {

    @FXML protected void checkOut() {
        showOrderPage();
    }

    public void showOrderPage(){
        placeOrder order =new placeOrder(this.app.stage);
   //     this.stage.hide();
        try {
            order.showWindow();
        } catch (Exception e){

        }
    }
    @FXML
    private Button checkoutButton;


    private cartPage app;
    public void setStage(cartPage app) {
        this.app = app;
    }
    @FXML
    public void onBack(){
        System.out.println("Cart Page");
        this.app.parentStage.show();
        this.app.stage.close();
    }
}


