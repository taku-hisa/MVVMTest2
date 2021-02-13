package com.example.mvvmtest2.data.service

import com.example.mvvmtest2.data.entity.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //QiitaService
    @GET("/api/v2/items")
    fun getItems(
        @Query("page")page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<Item>>
}