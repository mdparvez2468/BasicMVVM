package com.example.basicmvvm.retrofit

import com.example.basicmvvm.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}