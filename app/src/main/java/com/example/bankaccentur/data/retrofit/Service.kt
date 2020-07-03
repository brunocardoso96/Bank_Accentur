package com.example.bankaccentur.data.retrofit

import com.example.bankaccentur.data.model.StatementListResponse
import com.example.bankaccentur.data.model.UserAccountResponse
import retrofit2.Call
import retrofit2.http.*

interface Service {
    @GET("statements/{userId}")
    fun getStatement(
        @Path("userId") userId: Int
    ) : Call<StatementListResponse>

    @POST("login")
    @FormUrlEncoded
    fun postAluno(
        @Field("user") user:String,
        @Field("password") pass:String) : Call<UserAccountResponse>
}
