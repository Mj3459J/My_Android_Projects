package com.example.newsdata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface newsinterface {
    @GET("v2/top-headlines")
    static Call<newsdata> gettopheadline(@Query("country=us&apiKey=55b6e6e5855341ca8ec441aeecca466e")String country)
    {
    return null;
    }
}
