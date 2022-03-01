package com.example.basicmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basicmvvm.model.Product
import com.example.basicmvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI){

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
    get() = _products

    suspend fun getProducts(){
        val result = fakerAPI.getProducts()

        if (result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }

    }
}