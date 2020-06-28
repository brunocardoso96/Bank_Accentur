package com.example.bankaccentur.data

import com.example.bankaccentur.data.response.StatementListResponse
import retrofit2.Call
import retrofit2.http.GET

interface StatementService {
    @GET("statements/1")
    fun getStatement() : Call<StatementListResponse>
}