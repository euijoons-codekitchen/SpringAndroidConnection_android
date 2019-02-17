package com.example.recyclerviewprj.service;

import com.example.recyclerviewprj.dto.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {

    @POST("/library/user/login")
    Call<User> login(@Body User user);
//    @POST("/library/user/signup")
//    Call<User> signup(@Body User user);





    @FormUrlEncoded
    @POST("/library/user/signup")
    Call<User> signup(@Field("email") String email, @Field("passwd") String passwd);
}
