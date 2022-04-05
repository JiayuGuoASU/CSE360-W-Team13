package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.io.IOException;

public class DishDetail extends Application {
    Stage stage = new Stage();
    public Stage parentStage;

    public static void main(String[] args) {
        launch(args);
    }

    public DishDetail(Stage parentStage) {
        this.parentStage = parentStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DishDetail.fxml"));

//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("DishDetail");
        primaryStage.setScene(scene);
        TextField textField = new TextField();
        textField.setStyle(
                "-fx-pref-width: 200;" +
                        "-fx-pref-height: 50;" +
                        "-fx-font-size: 20;"
        );
        textField.setLayoutX(100);
        textField.setLayoutY(100);

        Tooltip tip = new Tooltip("xxxxx");
        textField.setTooltip(tip);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            this.parentStage.show();
            // Save file
        });
        DishDetailController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(this);
    }

    public void showWindow() throws IOException {
        start(stage);
    }
}
