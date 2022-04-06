package com.example.caferouge;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class cartController  {
    @FXML
    private ListView<String> cartListView=new ListView<String>();
    @FXML protected void checkOut() {
        showOrderPage();
    }
    @FXML
    public void initialize() {
        ObservableList<String> order = FXCollections.observableArrayList();
        Order currentOrder = GlobalData.getCurrentOrder();

        for(int i=0; i<currentOrder.dishes.size(); i++) {
            order.add(currentOrder.dishes.get(i).dishName+" : "+currentOrder.quantityOfDish.get(i).toString());
        }
        cartListView.setItems(order);
    }
    public void showOrderPage(){
        placeOrder order =new placeOrder(this.app.stage);
        this.app.stage.hide();
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


