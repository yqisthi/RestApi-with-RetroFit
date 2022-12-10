package com.example.restapiwithretrofit.api
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): retrofit2.Call<ArrayList<PostResponse>>
}