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
        receiptPage receipt =new receiptPage(this.stage);
        //       this.stage.hide();
        try {
//            (Stage)rootPane.getScene().getWindow()).close();
            receipt.showWindow();
        } catch (Exception e){

        }
    }
    @FXML
    ListView<String> orderList = new ListView<String>();

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
        cartPage backCart =new cartPage(this.stage);
        //     this.stage.hide();
        try {
            backCart.showWindow();
        } catch (Exception e){

        }
    }
    @FXML
    private Button placeOrder;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
