package com.example.caferouge;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class cartController  {
    private CartPage cart;
    @FXML
    private ListView<String> CART = new ListView<String>();

    @FXML protected void checkOut() {
        showOrderPage();
    }

    public void showOrderPage(){
        placeOrder order =new placeOrder(this.stage);
   //     this.stage.hide();
        try {
            order.showWindow();
        } catch (Exception e){

        }
    }

    @FXML
    public void init(){setCart();}
    public void setCart(){
        ObservableList<String> items = FXCollections.observableArrayList ();
        Order currentOrder = GlobalData.orders.get(GlobalData.orders.size()-1);
        for (int i=0;i< currentOrder.dishes.size();i++){
                items.add(GlobalData.dishes.get(i).dishName);
        }


        CART.setItems(items);
        }

        /*
        CART.setCellFactory(param -> new ListCell<String>() {
            @Override
            public void updateItem(String name, boolean empty){
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(name);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 1) {
                            /////////code//
                        }
                    });
                }
            }
        });
    }
    */
    @FXML public void backButton(){
        this.cart.parentStage.show();
        this.cart.stage.close();
    }

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}


