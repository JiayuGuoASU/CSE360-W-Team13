package com.example.caferouge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

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

        boolean isTure = false;

        String s1 = fieldUser.getText();

        String s2 = fieldPassword.getText();

        String s3 = "user";

        String s = JsonReaderWriter.readJsonFile("src/main/database.json");
        JSONObject jobj = JSON.parseObject(s);

        JSONArray user = jobj.getJSONArray("Users");
        for (int index = 0; index < user.size(); index++) {
            JSONObject key = (JSONObject) user.get(index);

            String Username = (String) key.get("username");
            String Password = (String) key.get("password");
            String userType = (String) key.get("userType");

            if(Username.equals(s1) && Password.equals(s2)){

                isTure = true;

                System.out.println("true");

            }else{

                System.out.println("error");
            }

        }


        if(isTure) {

            sign_successful si = new sign_successful();
            si.show_window();

        }else {

            sign_failure si = new sign_failure();
            si.show_window();

        }


    }

    public void loginAsAdminButton() throws IOException{

        boolean isTure = false;

        String s1 = fieldUser.getText();

        String s2 = fieldPassword.getText();

        String s3 = "admin";

        String s = JsonReaderWriter.readJsonFile("src/main/database.json");
        JSONObject jobj = JSON.parseObject(s);

        JSONArray user = jobj.getJSONArray("Users");
        for (int index = 0; index < user.size(); index++) {
            JSONObject key = (JSONObject) user.get(index);

            String Username = (String) key.get("username");
            String Password = (String) key.get("password");
            String userType = (String) key.get("userType");

            if(Username.equals(s1) && Password.equals(s2)){

                System.out.println("true");

                isTure = true;

            }else{

                System.out.println("error");
            }

        }

        if(isTure){

            sign_successful si = new sign_successful();
            si.show_window();
        }else {

            sign_failure si = new sign_failure();
            si.show_window();

        }

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