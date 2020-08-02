package com.example.fynadriver.drivers.server_connection.register_bagian_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultRegister1 {
    @SerializedName("result")
    @Expose
    private List<ResultRegister1> result = null;

    public List<ResultRegister1> getResult() {
        return result;
    }

    public void setResult(List<ResultRegister1> result) {
        this.result = result;
    }
}
