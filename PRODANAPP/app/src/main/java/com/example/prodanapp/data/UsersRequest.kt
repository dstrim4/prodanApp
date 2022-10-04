package com.example.prodanapp
import com.google.gson.annotations.SerializedName


// POST Employee
data class UsersRequest(
    @SerializedName("age")
    val age: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("salary")
    val salary: String
)