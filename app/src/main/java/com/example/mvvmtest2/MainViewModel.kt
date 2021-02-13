package com.example.mvvmtest2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.mvvmtest2.data.entity.Item
import com.example.mvvmtest2.data.repository.ItemDataSourceFactory

class MainViewModel(factory: ItemDataSourceFactory) : ViewModel() {
    private val config = PagedList.Config.Builder().setInitialLoadSizeHint(10).setPageSize(10).build()
    val entities: LiveData<PagedList<Item>> = LivePagedListBuilder(factory, config).build()
}