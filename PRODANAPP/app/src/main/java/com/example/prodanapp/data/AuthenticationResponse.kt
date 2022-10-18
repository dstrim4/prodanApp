package com.example.prodanapp
import com.google.gson.annotations.SerializedName
data class AuthenticationResponse(
    @SerializedName("jwt")
    val jwt: String,
    @SerializedName("user")
    val user: User
)