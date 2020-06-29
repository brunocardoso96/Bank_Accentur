package com.example.bankaccentur.data.retrofit

import com.example.bankaccentur.data.model.StatementListResponse
import retrofit2.Call
import retrofit2.http.GET

interface StatementService {
    @GET("statements/1")
    fun getStatement() : Call<StatementListResponse>
}