package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DishDetail extends Application {
    Stage stage = new Stage();
    private Stage parentStage;
    public static void main(String[] args) {
        launch(args);
    }
    public DishDetail(Stage parentStage){
        this.parentStage=parentStage;
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DishDetail.fxml"));

//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("DishDetail");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            this.parentStage.show();
            // Save file
        });
    }
    public void showWindow() throws IOException{
        start(stage);
    }
}
