package com.dzmitrykavalioum.bgs.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static final String BASE_URL = "http://192.168.1.42:8080/mobile/";
    static UserApi instance;
    private static Retrofit retrofit;

    static {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        instance = retrofit.create(UserApi.class);
    }

    private NetworkService() {
    }

    public static UserApi users() {
        return instance;
    }

    public NetworkService getUserApi() {
        return retrofit.create(NetworkService.class);
    }
}
