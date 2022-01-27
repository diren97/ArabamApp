package com.direnaydin.arabamcom.presentation.util.recycler

import android.view.ViewGroup
import com.direnaydin.arabamcom.common.adapters.BaseRecyclerAdapter

@Suppress("UNCHECKED_CAST")
class RecyclerViewAdapter : BaseRecyclerAdapter<RecyclerViewModel, RecyclerViewHolder<RecyclerViewModel>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<RecyclerViewModel> {
        return when (viewType) {
            RecyclerViewHolder.CarList.LAYOUT_ID -> RecyclerViewHolder.CarList(parent, viewType)
            else -> {
                throw IllegalArgumentException("View Holder type not defined!")
            }
        } as RecyclerViewHolder<RecyclerViewModel>
    }

}