package com.example.actividad5v2.network;

import com.example.actividad5v2.network.model.ImagineroResponse;
import com.example.actividad5v2.network.model.ImaginerosDeObras;
import com.example.actividad5v2.network.model.Obras;
import com.example.actividad5v2.network.model.ObrasResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ObrasApi {

    @GET("/obras/")
    Call<ObrasResponse> getObrasList();

    @GET("/imaginero/")
    Call<ImagineroResponse> getImagineroList();
}
