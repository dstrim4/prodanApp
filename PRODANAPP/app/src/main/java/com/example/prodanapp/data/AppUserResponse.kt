package com.example.prodanapp
import com.google.gson.annotations.SerializedName

data class AppUserResponse(
    @SerializedName("data")
    val `data`: AppUserData,
    @SerializedName("meta")
    val meta: Meta
)

data class AppUserData(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: Int
)

class Meta

data class Attributes(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("mailAppUser")
    val mailAppUser: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)