package com.example.prodanapp.data

import com.google.gson.annotations.SerializedName

data class AppUserRequest (
    @SerializedName("data")
    val data: AppUserData
)

data class AppUserData(
    @SerializedName("mailAppUser")
    val mailAppUser: String,
    @SerializedName("passAppUser")
    val passAppUser: String
)

