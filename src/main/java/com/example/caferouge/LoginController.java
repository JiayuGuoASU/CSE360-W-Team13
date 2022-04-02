package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginAsUserButton;
    private Button loginAsAdminButton;
    private Button createACC;


    @FXML



    public void createACC() throws IOException{

        CreateAccountPage cp = new CreateAccountPage();

        cp.show_Create_Account();

    }



    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}