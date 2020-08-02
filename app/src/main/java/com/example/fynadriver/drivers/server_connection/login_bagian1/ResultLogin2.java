package com.example.fynadriver.drivers.server_connection.login_bagian1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultLogin2 {
    @SerializedName("result")
    @Expose
    private List<ExampleLoginDriver2> result = null;

    public List<ExampleLoginDriver2> getResult() {
        return result;
    }

    public void setResult(List<ExampleLoginDriver2> result) {
        this.result = result;
    }
}
