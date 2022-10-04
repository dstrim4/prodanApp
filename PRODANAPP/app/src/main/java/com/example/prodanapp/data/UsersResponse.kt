package com.example.prodanapp
import com.google.gson.annotations.SerializedName


// POST Employee Response
data class UsersResponse(
    @SerializedName("data")
    val `data`: UserDetails,
    @SerializedName("status")
    val status: String
)

data class UserDetails(
    @SerializedName("age")
    val age: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("salary")
    val salary: String
)