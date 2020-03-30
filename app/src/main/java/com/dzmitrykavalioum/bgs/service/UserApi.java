package com.dzmitrykavalioum.bgs.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApi {

    static UserJ instance;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.42:8080/mobile/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        instance = retrofit.create(UserJ.class);
    }

    private UserApi() {
    }

    public static UserJ users() {
        return instance;
    }
}
