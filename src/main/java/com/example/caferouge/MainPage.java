package com.example.caferouge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

import java.util.ArrayList;

public class MainPage extends Application {
    public Stage mystage;
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("MainPage.fxml"));

//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(fxmlLoader.load());
        mystage=stage;
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        MainPageController newProjectController = fxmlLoader.getController();
        newProjectController.setStage(this);
    }
    public static void main(String[] args) {
        Dish d1=new Dish("Pizza",14,14);
        GlobalData.dishes.add(d1);
        d1 = new Dish("Handmade Noodles", 12, 12);
        GlobalData.dishes.add(d1);
        d1 = new Dish("Sushi", 12, 12);
        GlobalData.dishes.add(d1);
        d1 = new Dish("Garlic Butter Salmon", 12, 12);
        GlobalData.dishes.add(d1);
        GlobalData.dishesURL.put("Pizza",new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/Ruby_logo_64x64.png"));
        GlobalData.dishesURL.put("Handmade Noodles",new Image("http://findicons.com/files/icons/832/social_and_web/64/apple.png"));
        GlobalData.dishesURL.put("Sushi",new Image("http://antaki.ca/bloom/img/windows_64x64.png"));
        GlobalData.dishesURL.put("Garlic Butter Salmon",new Image("http://files.softicons.com/download/social-media-icons/fresh-social-media-icons-by-creative-nerds/png/64x64/twitter-bird.png"));
        GlobalData.dishesTemp=new ArrayList<>(GlobalData.dishes);
        launch();
    }
}
