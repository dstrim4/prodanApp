package com.example.prodanapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Sample (
    var number: Int,
    var color: String
) : Parcelable