package com.example.caferouge;

//by Boyang, 03/29

public class User{

    public String username;
    public String password;
    public String userType;

    public User(String name, String pwd, String type){
        username = name;
        password = pwd;
        userType = type;
    }

    public String getUsername(){

        return  username;

    }

    public String getPassword(){

        return  password;

    }

    public String getuserType() {

        return userType;

    }

    public void indentificationUserType(String inputType){

        userType = inputType;

    }
}
