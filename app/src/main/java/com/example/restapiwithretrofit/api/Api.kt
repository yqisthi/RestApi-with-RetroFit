package com.example.restapiwithretrofit.api
import retrofit2.http.GET

interface Api {
    @GET("data")
    fun getPosts(): retrofit2.Call<GraphData>
}