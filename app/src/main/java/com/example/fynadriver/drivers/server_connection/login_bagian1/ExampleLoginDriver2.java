package com.example.fynadriver.drivers.server_connection.login_bagian1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleLoginDriver2 {
    @SerializedName("REG1_PHONE")
    @Expose
    private String rEG1PHONE;

    public String getREG1PHONE() {
        return rEG1PHONE;
    }

    public void setREG1PHONE(String rEG1PHONE) {
        this.rEG1PHONE = rEG1PHONE;
    }
}
