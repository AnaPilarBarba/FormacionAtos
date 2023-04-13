package com.example.loginwithtoken.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("posts")
    var posts: List<Product>
)
