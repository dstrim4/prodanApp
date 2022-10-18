package com.example.prodanapp
import com.google.gson.annotations.SerializedName
data class RegisterResponse(
    @SerializedName("jwt")
    val jwt: String,
    @SerializedName("user")
    val user: User
)

data class User(
    @SerializedName("blocked")
    val blocked: Boolean,
    @SerializedName("confirmed")
    val confirmed: Boolean,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("username")
    val username: String
)