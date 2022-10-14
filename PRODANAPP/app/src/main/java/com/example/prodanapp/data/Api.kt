package com.example.prodanapp.data

import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("animals")
    suspend fun getAnimals() : Response<AnimalsResponse>
}