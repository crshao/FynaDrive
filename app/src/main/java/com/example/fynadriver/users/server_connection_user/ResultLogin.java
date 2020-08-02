package com.example.fynadriver.users.server_connection_user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultLogin {
    @SerializedName("phone_user")
    @Expose
    private String phoneUser;
    @SerializedName("password_fifi")
    @Expose
    private String passwordFifi;

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getPasswordFifi() {
        return passwordFifi;
    }

    public void setPasswordFifi(String passwordFifi) {
        this.passwordFifi = passwordFifi;
    }
}
