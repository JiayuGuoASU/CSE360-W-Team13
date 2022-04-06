package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class placeOrder extends Application {
    Stage stage = new Stage();
    public Stage parentStage;
    public static void main(String[] args) {
        launch(args);
    }
    public placeOrder(Stage parentStage){
        this.parentStage=parentStage;
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("placeOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Your Order");
        stage.setScene(scene);
        stage.show();
        orderController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(this);
    }
    public void showWindow() throws IOException{
        start(stage);
    }
}
