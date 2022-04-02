package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class placeOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("placeOrder.fxml"));
        //Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("Your Order");
        //stage.setScene(scene);
        //stage.show();
        LoginController newProjectController = fxmlLoader.getController();
       // newProjectController.setStage(stage);
    }
}
