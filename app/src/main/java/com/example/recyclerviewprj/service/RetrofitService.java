package com.example.recyclerviewprj.service;

import com.example.recyclerviewprj.GsonUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitObj(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().
                    baseUrl("http://192.168.0.16:8090/")
                    .addConverterFactory(GsonConverterFactory.create(GsonUtils.getGson()))
                    .build();
            return retrofit;
        }else
            return retrofit;

    }
}
