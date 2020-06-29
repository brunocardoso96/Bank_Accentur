package com.example.bankaccentur.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatementResponse(
    @Json(name ="title")
    val title: String,
    @Json(name ="desc")
    val desc: String,
    @Json(name ="date")
    val date: String,
    @Json(name ="value")
    val value: Double) {

    fun getStatementModel() =  StatementResponse(
        title = this.title,
        desc = this.desc,
        date = this.date,
        value = this.value)
}