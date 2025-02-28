package com.example.newsdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mycaller {
    Retrofit retrofit;
    String baseurl = "https://newsapi.org/";
    public static mycaller instance;

    private mycaller() {
        //nothing due to private
        retrofit=new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static mycaller getInstance() {
        if(instance==null) {
            instance = new mycaller();
            return instance;
        }
        else {
            return instance;
        }
    }
    public Retrofit getRetrofit() {
        return retrofit;
    }
}
