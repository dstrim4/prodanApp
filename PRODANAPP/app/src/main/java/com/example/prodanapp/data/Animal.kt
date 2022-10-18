package com.example.prodanapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Animal (
    val name : String,
    val age : String,
    val race : String,
    val description : String,
    val imgUrl : String

) : Parcelable