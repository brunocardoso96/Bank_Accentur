package com.example.bankaccentur.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserAccountResponse(
    val userAccount: UserResponse
)