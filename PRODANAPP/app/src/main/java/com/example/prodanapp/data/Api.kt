package com.example.prodanapp.data

import com.example.prodanapp.AuthenticationRequest
import com.example.prodanapp.AuthenticationResponse
import com.example.prodanapp.RegisterRequest
import com.example.prodanapp.RegisterResponse
import retrofit2.Response
import retrofit2.http.*
import java.net.Authenticator

interface Api {
    @GET("animals?populate=*")
    suspend fun getAnimals(@Header("Authorization") token: String) : Response<AnimalsResponse>

//    @GET("app-users/:userID")

    @POST("auth/local")
    suspend fun postAuthentication(@Body authReq : AuthenticationRequest) : Response<AuthenticationResponse>

    @POST("auth/local/register")
    suspend fun postRegister(@Body userReg : RegisterRequest) : Response<RegisterResponse>


}