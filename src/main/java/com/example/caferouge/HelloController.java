package com.example.caferouge;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private class NoticeListItemChangeListener implements ChangeListener<Object> {
        @Override
        public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
            System.out.println(newValue);
        }
    }
    private Stage stage;
    @FXML
    private Label welcomeText;
    @FXML
    private ListView<String> MENU = new ListView<String>();
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList ();
        for (int i=0;i<GlobalData.dishes.size();i++){
            items.add(GlobalData.dishes.get(i).dishName);
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
                    imageView.setImage(GlobalData.dishesURL.get(name));
                    setText(name);
                    setGraphic(imageView);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 2) {
                            showDishMenu();
                            System.out.println(name);
                        }
                    });
                }
            }
        });
//        MENU.getSelectionModel().selectedItemProperty().addListener(new NoticeListItemChangeListener());
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    public void showDishMenu(){
        DishDetail dd=new DishDetail(this.stage);
        this.stage.hide();
        try {
//            (Stage)rootPane.getScene().getWindow()).close();
            dd.showWindow();
        } catch (Exception e){

        }
    }
}
