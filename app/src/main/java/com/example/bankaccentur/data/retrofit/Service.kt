package com.example.bankaccentur.data.retrofit

import com.example.bankaccentur.data.model.StatementListResponse
import com.example.bankaccentur.data.model.UserAccountResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Service {
    @GET("statements/1")
    fun getStatement() : Call<StatementListResponse>

    @POST("login")
    fun postAluno(
        @Query("user") user:String = "test_user",
        @Query("password") password:String = "Test@1"
    ) : Call<UserAccountResponse>

}