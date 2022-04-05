package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountPage extends Application {
    Stage stage = new Stage();
    public static void main(String[] args) {        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cafe Rouge!");
        stage.setScene(scene);
        stage.show();
        LoginController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(stage);
    }

    public void show_Create_Account() throws IOException{
        start(stage);
    }
}