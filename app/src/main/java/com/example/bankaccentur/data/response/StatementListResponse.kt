package com.example.bankaccentur.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatementListResponse(
    @Json(name = "statementList")
    val statementList: List<StatementResponse>
)