package com.example.loginwithtoken.apis


import com.example.loginwithtoken.constants.Constants
import com.example.loginwithtoken.model.LoginRequest
import com.example.loginwithtoken.model.LoginResponse
import com.example.loginwithtoken.model.ProductResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET(Constants.POSTS_URL) //Peticion de traer toda la lista de los productos que hay con el token del usuario que ha iniciado sesión
    fun fetchPosts(): Call<ProductResponse>
}