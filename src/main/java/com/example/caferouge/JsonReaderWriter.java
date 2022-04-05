package com.example.caferouge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.*;
import java.io.FileOutputStream;

public class JsonReaderWriter {

    // Read json file
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");

            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Write json file
    public static boolean writeJsonFile(Object jsonData, String fileName) {

        try {
            File jsonFile = new File(fileName);
            Writer write = new OutputStreamWriter(new FileOutputStream(jsonFile), "utf-8");
            write.write(jsonData.toString());
            write.flush();
            write.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    static void readDatabase(){

    }
    public static void main(String[] args) {
//        String path = JsonReaderWriter.class.getClassLoader().getResource("src/main/resources/com/example/caferouge/database.json").getPath();
        String s = JsonReaderWriter.readJsonFile("src/main/resources/com/example/caferouge/database.json");
        JSONObject jobj = JSON.parseObject(s);
        JSONArray dish = jobj.getJSONArray("Dishes");
        JSONObject jobj_new = new JSONObject();
        JSONArray user = jobj.getJSONArray("Users");
        // JSONObject jobj_new_user = new JSONObject();

        for (int index = 0; index < dish.size(); index++) {
            JSONObject key = (JSONObject) dish.get(index);

            String Name = (String) key.get("name");
            Double Price = key.getDouble("price");
            String URL = (String) key.get("url");
            String Description = (String) key.get("description");
            Double time = key.getDouble("time");


            System.out.println(Name);
            System.out.println(Price);
            System.out.println(URL);
            System.out.println(Description);
            System.out.println(time);
            System.out.println();

        }

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

        // Adding more dishes to json
        JSONObject jobj_new_dish = new JSONObject();
        jobj_new_dish.put("name", "NEW");
        jobj_new_dish.put("price", 0);
        jobj_new_dish.put("url", "NEW");
        jobj_new_dish.put("description", "NEW");
        jobj_new_dish.put("time", 0);
        // System.out.println("jobj_new_dish:" + jobj_new_dish);
        dish.add(jobj_new_dish);

        // Adding more users to json
        JSONObject jobj_new_user = new JSONObject();
        jobj_new_user.put("username", "NEWNAME");
        jobj_new_user.put("password", "Newpassword");
        jobj_new_user.put("userType", "New");
        user.add(jobj_new_user);

        // System.out.println("jobj_new_user:" + jobj_new_user);
        // user.add(jobj_new_user);

        // populate the array
        jobj_new.put("Dishes", dish);
        System.out.println(JsonReaderWriter.writeJsonFile(jobj_new, "src/main/database.json"));
        jobj_new.put("Users", user);
        System.out.println(JsonReaderWriter.writeJsonFile(jobj_new, "src/main/database.json"));

        // print
        String formatStr = JSON.toJSONString(jobj_new_dish, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        // System.out.println(formatStr);

    }

}