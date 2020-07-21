package com.dzmitrykavalioum.bgs.service;


import android.content.Context;

import com.dzmitrykavalioum.bgs.MyCookieJar;

import java.net.CookieHandler;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NetworkService {

    private static final String BASE_URL ="https://board-game-battleground.herokuapp.com/mobile/";// "http://192.168.1.64:8080/mobile/";//"http://192.168.1.42:8080/mobile/";//"http://192.168.1.115:8080/mobile/";
    static UserApi instance;
    private static Retrofit retrofit;

    static {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //cookies auth
        JavaNetCookieJar jncj = new JavaNetCookieJar(CookieHandler.getDefault());

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).cookieJar(new MyCookieJar()).build();//new MyCookieJar()
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
