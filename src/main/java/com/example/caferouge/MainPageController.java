package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    private MainPage app;
    @FXML
    public void initialize() {

    }
    public void setStage(MainPage stage) {
        this.app = stage;
    }
    public void onMenuButton(){
        HelloApplication dd=new HelloApplication(this.app.mystage);
        this.app.mystage.hide();
        try {
            dd.showWindow();
        } catch (Exception e){
        }
    }
    public void onLoginButton() throws IOException {
        LoginPage lp = new LoginPage(this.app.mystage);
        lp.showWindow();
    }
}
