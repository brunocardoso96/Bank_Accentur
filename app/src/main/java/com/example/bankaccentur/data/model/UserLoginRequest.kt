package com.example.bankaccentur.data.model

import com.squareup.moshi.Json

data class UserLoginRequest(
    @Json(name = "user")
    val user:String = "test_user",
    @Json(name = "password")
    val pass:String = "Test@1"
)