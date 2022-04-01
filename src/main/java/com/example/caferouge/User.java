package com.example.caferouge;

//by Boyang, 03/29

public class User{

    public String username;
    public String password;
    public int userType;

    public User(String name, String pwd, int type){
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

    public int getuserType() {

        return userType;

    }

    public void indentificationUserType(int inputType){

        userType = inputType;

    }
}
