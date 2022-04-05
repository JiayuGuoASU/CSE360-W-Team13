package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage extends Application {
    public Stage parentStage;
    Stage stage = new Stage();
    public static void main(String[] args) {
        launch(args);
    }


    public LoginPage(Stage parentStage){
        this.parentStage=parentStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Log in!");
        stage.setScene(scene);
        stage.show();
        LoginController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(this);
    }

    public void showWindow() throws IOException{
        this.parentStage=parentStage;
        start(stage);
    }
}