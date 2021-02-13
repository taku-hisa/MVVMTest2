package com.example.mvvmtest2.data.repository

import androidx.paging.DataSource
import com.example.mvvmtest2.data.entity.Item
import com.example.mvvmtest2.data.service.ApiInterface

class ItemDataSourceFactory(service: ApiInterface) : DataSource.Factory<Int, Item>() {
    private val source = ItemDataSource(service)

    override fun create(): DataSource<Int, Item> {
        return source
    }
}