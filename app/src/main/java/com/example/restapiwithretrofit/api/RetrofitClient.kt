package com.example.restapiwithretrofit.api

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
object RetrofitClient {
    private const val BASE_URL = "https://monitoring.cemebsa.com/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}