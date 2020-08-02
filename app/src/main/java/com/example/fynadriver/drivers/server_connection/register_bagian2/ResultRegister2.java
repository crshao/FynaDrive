package com.example.fynadriver.drivers.server_connection.register_bagian2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultRegister2 {
    @SerializedName("result")
    @Expose
    private List<ExampleRegister2> result = null;

    public List<ExampleRegister2> getResult() {
        return result;
    }

    public void setResult(List<ExampleRegister2> result) {
        this.result = result;
    }
}
