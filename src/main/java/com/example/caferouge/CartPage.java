package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CartPage extends Application{
    Stage stage = new Stage();
    public Stage parentStage;
    public static void main(String[] args) {
        launch(args);
    }
    public CartPage(Stage parentStage) {this.parentStage=parentStage;}
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cart.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cart");
        stage.setScene(scene);
        stage.show();
        cartController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(stage);
    }

    public void showWindow() throws IOException{
        start(stage);
    }
}

