package com.example.bankaccentur.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StatementApi {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bank-app-test.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: StatementService = initRetrofit()
        .create(StatementService::class.java)
}