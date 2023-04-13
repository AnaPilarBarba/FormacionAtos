package com.example.loginwithtoken.model

import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("content")
    var content: String
)
