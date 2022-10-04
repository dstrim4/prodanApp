package com.example.prodanapp.data

import com.example.prodanapp.UsersRequest
import com.example.prodanapp.UsersResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("employees")
    suspend fun getEmployees() : Response<EmployeeResponse>

    @POST("create")
    suspend fun createEmployee(@Body usersRequest : UsersRequest) : Response<UsersResponse>



}