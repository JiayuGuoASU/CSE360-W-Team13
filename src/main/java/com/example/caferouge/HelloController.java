package com.example.caferouge;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    private class NoticeListItemChangeListener implements ChangeListener<Object> {
        @Override
        public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
            System.out.println(newValue);
        }
    }

    private HelloApplication app;

    @FXML
    private Label welcomeText;
    @FXML
    private TextField SERACHTEXT;
    @FXML
    private ListView<String> MENU = new ListView<String>();
    @FXML

    //TODO login page
    //protected void loginButtonClick() throws IOException{
    //        LoginPage lp = new LoginPage();
    //        lp.showWindow();

    //    }
    protected void onHelloButtonClick() throws IOException{
        welcomeText.setText("Welcome to JavaFX Application!");
        showCheckout();
        LoginPage lp = new LoginPage();
        lp.showWindow();
    }

    public void showCheckout(){
        CartPage cart =new CartPage(this.app.stage);
        this.app.stage.hide();
        try {
            cart.showWindow();
        } catch (Exception e){

        }

    }
    @FXML
    public void initialize() {
        setMenu();
    }
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
    public void setStage(HelloApplication stage) {
        this.app = stage;
    }
    @FXML
    public void showDishMenu(String name){
        DishDetail dd=new DishDetail(this.app.stage, name);
//        System.out.println("HelloController: "+name);
        this.app.stage.hide();
        try {
//            (Stage)rootPane.getScene().getWindow()).close();
            dd.showWindow();
        } catch (Exception e){

        }
    }
    @FXML
    public void onSearch(){
        String searchStr=SERACHTEXT.getText();
        if (searchStr.compareTo("")==0){
            GlobalData.dishesTemp=new ArrayList<>(GlobalData.dishes);
            setMenu();
            return;
        }
        GlobalData.dishesTemp.clear();
        for (int i=0;i<GlobalData.dishes.size();i++){
            if (GlobalData.dishes.get(i).dishName.toLowerCase().contains(searchStr.toLowerCase())){
                GlobalData.dishesTemp.add(GlobalData.dishes.get(i));
            }
        }
        setMenu();
    }
    @FXML
    public void onBackButton(){
        this.app.parentStage.show();
        this.app.stage.close();
    }
}
