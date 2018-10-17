package com.udacity.nanodegree.bakingapp.utils;

import com.udacity.nanodegree.bakingapp.BuildConfig;
import com.udacity.nanodegree.bakingapp.data.service.BakingService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    public static Retrofit getRetrofit(String baseURL) {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static BakingService getBakingService() {
        return getRetrofit(BuildConfig.RECIPES_BASE_URL).create(BakingService.class);
    }

}
