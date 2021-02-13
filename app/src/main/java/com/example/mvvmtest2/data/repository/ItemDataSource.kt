package com.example.mvvmtest2.data.repository

import androidx.paging.PageKeyedDataSource
import com.example.mvvmtest2.data.entity.Item
import com.example.mvvmtest2.data.service.ApiInterface

class ItemDataSource(private val service: ApiInterface) : PageKeyedDataSource<Int, Item>() {
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {}

    // API呼び出しをしているので、本来であればここで例外の対処を記述する必要がありますが省略しています。
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        // 1 ページ目のデータを取得する
        val page = 1
        // 1 ページに表示するデータ数
        val perPage = params.requestedLoadSize
        // ページに表示するデータを取得する
        val items = service.getItems(page, perPage).execute().body() ?: emptyList()
        // 次に表示するページの番号を計算する
        val nextPage = page + 1
        // 取得したデータ、次に表示するページの番号を結果として返す
        callback.onResult(items , null, nextPage)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        // params.key には 前の loadInitial や loadAfter の呼び出しで返した nextPage が格納されている
        val page = params.key // 1 ページ目のデータを取得する
        // params.requestedLoadSize には 1ページに表示するデータ数が格納されている。
        val perPage = params.requestedLoadSize
        // ページに表示するデータを取得する
        val items = service.getItems(page, perPage).execute().body() ?: emptyList()
        // 次に表示するページの番号を計算する
        val nextPage = page + 1
        // 取得したデータ、次に表示するページの番号を結果として返す
        callback.onResult(items, nextPage)
    }
}