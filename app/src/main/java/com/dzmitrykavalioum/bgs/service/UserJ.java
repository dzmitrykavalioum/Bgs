package com.dzmitrykavalioum.bgs.service;

import com.dzmitrykavalioum.bgs.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//http://localhost:8080/mobile/sign_in/111&111

public interface UserJ {

    @GET("sign_in/{login}&{password}")
    Call<UserResponse> signIn(@Path("login") String login, @Path ("password") String password);

    @POST ("registration")
    public Call<UserResponse> registration (@Body UserResponse userResponse);



}
