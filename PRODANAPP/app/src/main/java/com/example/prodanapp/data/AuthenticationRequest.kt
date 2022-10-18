package com.example.prodanapp
import com.google.gson.annotations.SerializedName

data class AuthenticationRequest(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("password")
    val password: String
)