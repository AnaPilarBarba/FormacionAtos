package com.example.helploginwithtoken

import android.app.role.RoleManager
import com.google.gson.annotations.SerializedName

data class User(

    var id: String,

    var name: String,

    @SerializedName("first_name")
    var firstName: String,

    @SerializedName("last_name")
    var lastName: String,

    var email: String,

    var das: String,

    var rol: Rol,

    var enable: Boolean,

    var sizeComments: Int,

    var image: ByteArray
)


