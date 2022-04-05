package com.example.caferouge;
//CreateAccountPageController

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;

// Adding more users to json
//        JSONObject jobj_new_user = new JSONObject();
//                jobj_new_user.put("username", "NEWNAME");
//                jobj_new_user.put("password", "Newpassword");
//                jobj_new_user.put("userType", "New");
//                user.add(jobj_new_user);

// System.out.println("jobj_new_user:" + jobj_new_user);
// user.add(jobj_new_user);


public class CreateAccountPageController{

    @FXML
    private Button clickRegisterButton;
    @FXML
    private TextField userT;
    @FXML
    private TextField pwdT;

    @FXML
    public void clickRegisterButton() throws IOException {

        String s = JsonReaderWriter.readJsonFile("src/main/data_tmp.json");
        JSONObject jobj = JSON.parseObject(s);
        JSONArray user = jobj.getJSONArray("Users");

        userT.getText();

        JSONObject jobj_new_user = new JSONObject();
        jobj_new_user.put("username", userT.getText());
        jobj_new_user.put("password", pwdT.getText());
        jobj_new_user.put("userType", "New");

        user.add(jobj_new_user);
        System.out.println("jobj_new_user:" + jobj_new_user);
        user.add(jobj_new_user);


    }
    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}