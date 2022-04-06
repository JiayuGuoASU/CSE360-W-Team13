package com.example.caferouge;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class orderController {

    @FXML
    protected void orderPlace() {
        showReceipt();
    }
    public void showReceipt(){
        GlobalData.currentOrder.user=GlobalData.user;
        GlobalData.orders.add(GlobalData.currentOrder);
        receiptPage receipt =new receiptPage(this.app.stage);
        this.app.stage.close();
        try {
//            (Stage)rootPane.getScene().getWindow()).close();
            receipt.showWindow();
        } catch (Exception e){
        }
    }
    @FXML
    public void initialize(){
        setOrders();
    }

    @FXML
    private ListView<String> orderList = new ListView<String>();

    public void setOrders(){
        ObservableList<String> order = FXCollections.observableArrayList();
        Order currentOrder = GlobalData.getCurrentOrder();

        for(int i=0; i<currentOrder.dishes.size(); i++) {
            order.add(currentOrder.dishes.get(i).dishName);
        }
        orderList.setItems(order);
    }
    @FXML
    protected void backToCart() {
        showCartPage();
    }

    public void showCartPage(){
        this.app.parentStage.show();
        this.app.stage.close();
    }
    @FXML
    private Button placeOrder;

    private placeOrder app;

    public void setStage(placeOrder app) {
        this.app = app;
    }

}
