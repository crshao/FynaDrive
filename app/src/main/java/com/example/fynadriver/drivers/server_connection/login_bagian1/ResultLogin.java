package com.example.fynadriver.drivers.server_connection.login_bagian1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultLogin {
    @SerializedName("result")
    @Expose
    private List<ExampleLoginDriver> result = null;

    public List<ExampleLoginDriver> getResult() {
        return result;
    }

    public void setResult(List<ExampleLoginDriver> result) {
        this.result = result;
    }
}
