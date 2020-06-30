package com.example.bankaccentur.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserAccountResponse(
    @Json(name ="userAccount")
    val userAccount: UserResponse
)