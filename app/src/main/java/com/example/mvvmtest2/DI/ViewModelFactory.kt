package com.example.mvvmtest2.DI

import com.example.mvvmtest2.MainViewModel
import com.example.mvvmtest2.data.repository.ItemDataSourceFactory
import com.example.mvvmtest2.data.service.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ViewModelFactory {
    private val retrofit get() = Retrofit.Builder()
        .baseUrl("https://qiita.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ApiInterface::class.java)

    val mainViewModel: MainViewModel get() = MainViewModel(ItemDataSourceFactory(service))
}