package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button placeOrder;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
