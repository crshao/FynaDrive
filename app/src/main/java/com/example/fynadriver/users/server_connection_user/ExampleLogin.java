package com.example.fynadriver.users.server_connection_user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExampleLogin {
    @SerializedName("result")
    @Expose
    private ResultLogin result;

    public ResultLogin getResult() {
        return result;
    }

    public void setResult(ResultLogin result) {
        this.result = result;
    }
}
