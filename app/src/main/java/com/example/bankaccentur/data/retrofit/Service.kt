package com.example.bankaccentur.data.retrofit

import com.example.bankaccentur.data.model.StatementListResponse
import com.example.bankaccentur.data.model.UserAccountResponse
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @GET("statements/1")
    fun getStatement() : Call<StatementListResponse>

    @POST("login")
    @FormUrlEncoded
    fun postAluno(
        @Field("user") user:String,
        @Field("password") pass:String) : Call<UserAccountResponse>
}

/*

@POST("login")
fun postAluno(user, password) : Call<UserAccountResponse>

*/