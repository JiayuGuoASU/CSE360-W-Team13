package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginAsUserButton;
    @FXML
    private Button loginAsAdminButton;
    @FXML
    private Button createACC;
    @FXML
    private TextField fieldUser;
    @FXML
    private PasswordField fieldPassword;




    public void loginAsUserButton() throws IOException{

        fieldUser.getText();

        System.out.println( fieldUser.getText());


    }

    public void loginAsAdminButton() throws IOException{



    }

    public void createACC() throws IOException{

        CreateAccountPage cp = new CreateAccountPage();

        cp.show_Create_Account();

    }



    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}