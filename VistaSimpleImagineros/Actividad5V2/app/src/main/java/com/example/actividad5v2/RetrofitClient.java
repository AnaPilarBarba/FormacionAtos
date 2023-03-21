package com.example.actividad5v2;

import android.content.Context;

import com.example.actividad5v2.network.ObrasApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private ObrasApi obrasApi;

    public ObrasApi getObrasApi() {
        return obrasApi;
    }

    public RetrofitClient(Context ctx) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obrasApi =retrofit.create(ObrasApi.class);
    }
}
