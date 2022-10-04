package com.example.prodanapp.data

import com.google.gson.annotations.SerializedName


// GET Employee
data class EmployeeResponse(
    @SerializedName("data")
    val `data`: List<EmployeeDetails>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)

data class EmployeeDetails(
    @SerializedName("employee_age")
    val employeeAge: Int,
    @SerializedName("employee_name")
    val employeeName: String,
    @SerializedName("employee_salary")
    val employeeSalary: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("profile_image")
    val profileImage: String
)