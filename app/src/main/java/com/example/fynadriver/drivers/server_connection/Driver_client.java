package com.example.fynadriver.drivers.server_connection;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Driver_client {
    public static final String BASE_URL = "https://sheepish-accelerati.000webhostapp.com/";
    public static Retrofit getClient(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
