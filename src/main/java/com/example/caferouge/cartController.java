package com.example.caferouge;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class cartController  {

    private cartPage cartPage;

    @FXML
    private ListView<String> CART = new ListView();

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
/*
    public void setMenu(){
        ObservableList<String> items = FXCollections.observableArrayList ();
        for (int i=0;i<GlobalData.dishesTemp.size();i++){
            items.add(GlobalData.dishesTemp.get(i).dishName);
        }

        MENU.setItems(items);
        MENU.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty){
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    imageView.setImage(new Image(GlobalData.dishesURL.get(name)));
                    setText(name);
                    setGraphic(imageView);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 2) {
                            showDishMenu(name);
                            System.out.println(name);
                        }
                    });
                }
            }
        });
    }
    */
    @FXML public void backButton(){
        this.cartPage.parentStage.show();
        this.cartPage.stage.close();
    }

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}


