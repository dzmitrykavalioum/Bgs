package com.dzmitrykavalioum.bgs.service;


import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {

    private static final String BASE_URL ="http://s281763.savps.ru/mobile/";// "http://192.168.1.64:8080/mobile/";//"http://192.168.1.42:8080/mobile/";//"http://192.168.1.115:8080/mobile/";
    static UserApi instance;
    private static Retrofit retrofit;

    static {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())                  //addConverterFactory(GsonConverterFactory.create())
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
