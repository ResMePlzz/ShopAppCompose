package com.example.shopappcomposefinal.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{

    private val baseUrl = "https://dummyjson.com/"


    private var retrofit: Retrofit =
        Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofitApi: RetrofitApi = retrofit.create(RetrofitApi::class.java)
}