package com.example.fynadriver.drivers.server_connection.login_bagian1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleLoginDriver {
    @SerializedName("REG2_PASSWORD")
    @Expose
    private String rEG2PASSWORD;

    public String getREG2PASSWORD() {
        return rEG2PASSWORD;
    }

    public void setREG2PASSWORD(String rEG2PASSWORD) {
        this.rEG2PASSWORD = rEG2PASSWORD;
    }
}
