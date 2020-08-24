package com.example.bankaccentur.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@JsonClass(generateAdapter = true)
data class UserResponse (
    @Json(name ="userId")
    val userId: Int,

    @Json(name ="name")
    val name: String,

    @Json(name ="bankAccount")
    val bankAccount: String,

    @Json(name ="agency")
    val agency: String,

    @Json(name ="balance")
    val balance: Double
)