package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    Stage stage = new Stage();
    public Stage parentStage;
    public HelloApplication(Stage parentStage){
        this.parentStage=parentStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        HelloController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(this);
    }

    public void showWindow() throws IOException{
        start(stage);
    }
}