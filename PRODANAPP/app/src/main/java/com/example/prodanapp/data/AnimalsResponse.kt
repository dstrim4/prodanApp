package com.example.prodanapp.data
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

data class AnimalsResponse(
    @SerializedName("data")
    val `data`: List<AnimalData>,
    @SerializedName("meta")
    val meta: Meta
)

data class AnimalData(
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
    @SerializedName("imgAnimal")
    val imgAnimal: ImgAnimal,
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

@Parcelize
data class ImgAnimal(
    @SerializedName("data")
    val `data`: List<DataX>
) : Parcelable

@Parcelize
data class DataX(
    @SerializedName("attributes")
    val attributes: AttributesX,
    @SerializedName("id")
    val id: Int
) : Parcelable

@Parcelize
data class AttributesX(
    @SerializedName("alternativeText")
    val alternativeText: String,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("ext")
    val ext: String,
    @SerializedName("formats")
    val formats: Formats,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mime")
    val mime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("previewUrl")
    val previewUrl: @RawValue Any? = null,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("provider_metadata")
    val providerMetadata: ProviderMetadataXXXX,
    @SerializedName("size")
    val size: Double,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
) : Parcelable

@Parcelize
data class Formats(
    @SerializedName("large")
    val large: Large,
    @SerializedName("medium")
    val medium: Medium,
    @SerializedName("small")
    val small: Small,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail
) : Parcelable


@Parcelize
data class ProviderMetadataXXXX(
    @SerializedName("public_id")
    val publicId: String,
    @SerializedName("resource_type")
    val resourceType: String
) : Parcelable

@Parcelize
data class Large(
    @SerializedName("ext")
    val ext: String,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mime")
    val mime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path")
    val path: @RawValue Any? = null,
    @SerializedName("provider_metadata")
    val providerMetadata: ProviderMetadataXXXX,
    @SerializedName("size")
    val size: Double,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
) : Parcelable

@Parcelize
data class Medium(
    @SerializedName("ext")
    val ext: String,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mime")
    val mime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path")
    val path: @RawValue Any?= null,
    @SerializedName("provider_metadata")
    val providerMetadata: ProviderMetadataXXXX,
    @SerializedName("size")
    val size: Double,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
) : Parcelable

@Parcelize
data class Small(
    @SerializedName("ext")
    val ext: String,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mime")
    val mime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path")
    val path: @RawValue Any? = null,
    @SerializedName("provider_metadata")
    val providerMetadata: ProviderMetadataXXXX,
    @SerializedName("size")
    val size: Double,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
) : Parcelable

@Parcelize
data class Thumbnail(
    @SerializedName("ext")
    val ext: String,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mime")
    val mime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("path")
    val path: @RawValue Any? = null,
    @SerializedName("provider_metadata")
    val providerMetadata: ProviderMetadataXXXX,
    @SerializedName("size")
    val size: Double,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
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