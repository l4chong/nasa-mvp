package com.lc.mvppictureoftheday.api;


import com.lc.mvppictureoftheday.models.NasaItem;
import com.lc.mvppictureoftheday.utils.Constants;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaService {

    @GET("planetary/apod")
    Call<NasaItem> getItem(@Query("api_key") String apikey);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
