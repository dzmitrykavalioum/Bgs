package com.dzmitrykavalioum.bgs.service;

import com.dzmitrykavalioum.bgs.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

//http://localhost:8080/mobile/sign_in/111&111

public interface UserApi {

//    @GET("sign_in/{login}&{password}")
//    Call<UserResponse> signIn(@Path("login") String login, @Path ("password") String password);

    @GET("user")
    Call<UserResponse> signIn(@Query("login") String login, @Query("password") String password);

    @POST("user")
    Call<UserResponse> registration(@Body UserResponse userResponse);
//
//    @POST("registration")
//    public Call<UserResponse> registration(@Body UserResponse userResponse);

    @PUT("user")
    Call<UserResponse> update(@Query("id") int id, @Body UserResponse changedUser);

    //  @DELETE ("user")


}
