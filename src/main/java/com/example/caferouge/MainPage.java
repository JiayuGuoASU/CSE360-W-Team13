package com.example.caferouge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainPage extends Application {
    public Stage mystage;
    MainPageController myController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("MainPage.fxml"));

//      Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(fxmlLoader.load());
        mystage = stage;
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        MainPageController newProjectController = fxmlLoader.getController();
        myController=newProjectController;
        newProjectController.setStage(this);
        createMockData();
    }

    public static boolean AddDish(String newName, Double newPrice, Double newTime, String newURL) {
        // Adding more dishes to json (Unlinked with system)
        String s = JsonReaderWriter.readJsonFile("src/main/data_tmp.json");
        JSONObject jobj = JSON.parseObject(s);
        JSONArray dish = jobj.getJSONArray("Dishes");
        JSONObject jobj_new_dish = new JSONObject();
        JSONObject jobj_new = new JSONObject();

        jobj_new_dish.put("name", newName);
        jobj_new_dish.put("price", newPrice);
        jobj_new_dish.put("url", newURL);
        //jobj_new_dish.put("description", "NEW");
        jobj_new_dish.put("time", newTime);

        dish.add(jobj_new_dish);
        jobj_new.put("Dishes", dish);
        System.out.println(JsonReaderWriter.writeJsonFile(jobj_new, "src/main/database.json"));
        return true;
    }
    public void createMockData(){
        Order oder=new Order();
        oder.dishes.add(GlobalData.dishes.get(0));
        oder.quantityOfDish.add(1);
        oder.dishes.add(GlobalData.dishes.get(1));
        oder.quantityOfDish.add(2);
        oder.calculateCookingTime();
        GlobalData.orders.add(oder);
    }
    public void refreshByLogin(){

    }
    public static void main(String[] args) {
        String s = JsonReaderWriter.readJsonFile("src/main/data_tmp.json");
        JSONObject jobj = JSON.parseObject(s);
        JSONArray dish = jobj.getJSONArray("Dishes");
        JSONObject jobj_new = new JSONObject();
        JSONArray user = jobj.getJSONArray("Users");


        for (int index = 0; index < dish.size(); index++) {
            JSONObject key = (JSONObject) dish.get(index);
            String Name = (String) key.get("name");
            Double Price = key.getDouble("price");
            String URL = (String) key.get("url");
            String Description = (String) key.get("description"); //?? if it needs to be added or not
            Double Time = key.getDouble("time");

            Dish d1 = new Dish(Name, Price, Time, Description);
            GlobalData.dishes.add(d1);
            GlobalData.dishesURL.put(Name, URL);
        }
        GlobalData.dishesTemp = new ArrayList<>(GlobalData.dishes);
        launch();
        /*
        // User database (unlinked with the system)
        for (int index = 0; index < user.size(); index++) {
            JSONObject key = (JSONObject) user.get(index);

            String Username = (String) key.get("username");
            String Password = (String) key.get("password");
            String userType = (String) key.get("userType");

            System.out.println(Username);
            System.out.println(Password);
            System.out.println(userType);
            System.out.println();

        }

        // Adding more dishes to json (Unlinked with system)
        AddDish("NEW",0.0,0.0,"https://icons.iconarchive.com/icons/majdi-khawaja/kung-fu-panda/64/Po-3-icon.png");


        // Adding more users to json
        JSONObject jobj_new_user = new JSONObject();
        jobj_new_user.put("username", "NEWNAME");
        jobj_new_user.put("password", "Newpassword");
        jobj_new_user.put("userType", "New");
        user.add(jobj_new_user);

        // System.out.println("jobj_new_user:" + jobj_new_user);
        // user.add(jobj_new_user);

        // populate the array

        jobj_new.put("Users", user);
        //System.out.println(JsonReaderWriter.writeJsonFile(jobj_new, "src/main/database.json"));

        // print
        //String formatStr = JSON.toJSONString(jobj_new_dish, SerializerFeature.PrettyFormat,
                //SerializerFeature.WriteMapNullValue,
                //SerializerFeature.WriteDateUseDateFormat);
        // System.out.println(formatStr);
        */
    }
}

