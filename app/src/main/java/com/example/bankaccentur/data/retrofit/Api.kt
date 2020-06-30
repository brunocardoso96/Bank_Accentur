package com.example.bankaccentur.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bank-app-test.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val serviceStatement: Service = initRetrofit()
        .create(Service::class.java)

    val serviceUser: Service = initRetrofit()
        .create(Service::class.java)

}