package com.example.wordle.project.requestbody;



public class StartGameRequestBody {

    public String userEmailAddress;

    public StartGameRequestBody() {

    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }


    public StartGameRequestBody(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }


}
