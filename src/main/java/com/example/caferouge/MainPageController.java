package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
    @FXML
    public void onLogoutButton(){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Logout");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText("Logout Successfully!");
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }
}
