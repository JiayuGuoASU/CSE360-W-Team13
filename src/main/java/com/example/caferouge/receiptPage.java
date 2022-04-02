package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class receiptPage extends Application {
    Stage stage = new Stage();
    public static void main(String[] args) {
        launch(args);
    }
    Stage parentStage;
    public receiptPage(Stage parentStage){
        this.parentStage=parentStage;
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("receipt.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Your Order");
        stage.setScene(scene);
        stage.show();
        receiptController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(this.stage);
    }
    public void showWindow() throws IOException{
        start(stage);
    }
}
