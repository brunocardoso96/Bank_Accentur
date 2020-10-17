package com.example.bankaccentur.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatementListResponse(
    val statementList: List<StatementResponse>
)