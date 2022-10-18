package com.example.prodanapp.data

import com.example.prodanapp.AppUserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("animals")
    suspend fun getAnimals() : Response<AnimalsResponse>

//    @GET("app-users/:userID")

    @POST("app-users")
    suspend fun postAppUsers(@Body appUserReq : AppUserRequest) : Response<AppUserResponse>


}