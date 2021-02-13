package com.example.mvvmtest2.Epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.mvvmtest2.LayoutEpoxyItemBindingModel_

import com.example.mvvmtest2.data.entity.Item

class ItemPagedListController : PagedListEpoxyController<Item>() {
    override fun buildItemModel(currentPosition: Int, item: Item?): EpoxyModel<*> {
        requireNotNull(item)
        return LayoutEpoxyItemBindingModel_().apply {
            id(item.id)
            title(item.title)
        }
    }
}