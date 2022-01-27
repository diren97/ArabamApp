package com.direnaydin.arabamcom.common.adapters

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.direnaydin.arabamcom.common.interfaces.DiffAdapter
import com.direnaydin.arabamcom.common.interfaces.RecyclerItem
import com.direnaydin.arabamcom.common.viewholders.BaseViewHolder
import kotlin.properties.Delegates

abstract class BaseRecyclerAdapter<RI : RecyclerItem, VH : BaseViewHolder<RI>> :RecyclerView.Adapter<VH>(),
    DiffAdapter {

    private var onItemClick: ((RI, Int) -> Unit) = { _, _ -> }
    private var onViewClick: ((RI, View, Int) -> Unit) = { _, _, _ -> }

    var items: List<RI> by Delegates.observable(emptyList()) { _, old, new ->
        this@BaseRecyclerAdapter.notifyDataSetChanged()
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    @LayoutRes
    override fun getItemViewType(position: Int) = items[position].layoutId

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, pos: Int) =
            holder.bindItem(
                    item = items[pos],
                    onItemClick = onItemClick,
                    onViewClick = onViewClick
            )

    fun onItemClick(onClick: ((RI, Int) -> Unit)): BaseRecyclerAdapter<RI, *> {
        this.onItemClick = onClick
        return this
    }

    fun onViewClick(onClick: ((RI, View, Int) -> Unit)): BaseRecyclerAdapter<RI, *> {
        this.onViewClick = onClick
        return this
    }

}
