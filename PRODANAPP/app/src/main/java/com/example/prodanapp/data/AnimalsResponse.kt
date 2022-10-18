package com.example.prodanapp.data
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class AnimalsResponse(
    @SerializedName("data")
    val `data`: List<AnimalsData>,
    @SerializedName("meta")
    val meta: Meta
)

data class AnimalsData(
    @SerializedName("attributes")
    val sample: Sample,
    @SerializedName("id")
    val id: Int
)

data class Meta(
    @SerializedName("pagination")
    val pagination: Pagination
)

@Parcelize
data class Sample(
    @SerializedName("adoptado")
    val adoptado: Boolean,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("descripcionAnimal")
    val descripcionAnimal: String,
    @SerializedName("edadAnimal")
    val edadAnimal: Int,
    @SerializedName("nomAnimal")
    val nomAnimal: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("razaAnimal")
    val razaAnimal: String,
    @SerializedName("sexoAnimal")
    val sexoAnimal: String,
    @SerializedName("updatedAt")
    val updatedAt: String
) : Parcelable

data class Pagination(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("total")
    val total: Int
)