package com.example.fynadriver.users.server_connection_user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPojo {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_user")
    @Expose
    private String namaUser;
    @SerializedName("email_user")
    @Expose
    private String emailUser;
    @SerializedName("phone_user")
    @Expose
    private String phoneUser;
    @SerializedName("password_fifi")
    @Expose
    private String passwordFifi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

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
