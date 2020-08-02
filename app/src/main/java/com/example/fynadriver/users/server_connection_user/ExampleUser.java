package com.example.fynadriver.users.server_connection_user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExampleUser {
    @SerializedName("result")
    @Expose
    private List<UserPojo> result = null;

    public List<UserPojo> getResult() {
        return result;
    }

    public void setResult(List<UserPojo> result) {
        this.result = result;
    }
}
