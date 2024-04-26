package com.example.shopappcomposefinal.data.retrofit

import com.example.shopappcomposefinal.domain.model.ModelAllProducts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {

    @GET(value = "products")
    fun getAllProducts(): Call<ModelAllProducts>

    @GET(value = "products/categories")
    suspend fun getAllCategory(): List<String>

    @GET(value = "products/category/{category}")
    fun getProductOfCategory(@Path("category") category: String): Call<ModelAllProducts>

}