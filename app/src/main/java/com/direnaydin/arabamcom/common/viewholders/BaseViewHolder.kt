package com.direnaydin.arabamcom.common.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.direnaydin.arabamcom.common.interfaces.RecyclerItem
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<RI : RecyclerItem> :RecyclerView.ViewHolder, LayoutContainer {

    protected var onViewClick: ((RI, View, Int) -> Unit) = { _, _, _ -> }

    constructor(parent: ViewGroup, @LayoutRes layoutId: Int) : this(
            LayoutInflater.from(parent.context).inflate(
                    layoutId,
                    parent,
                    false
            )
    )

    private constructor(itemView: View) : super(itemView)

    override val containerView: View?
        get() = this.itemView

    abstract fun bindItem(item: RI)

    internal fun bindItem(
            item: RI,
            onItemClick: (RI, Int) -> Unit,
            onViewClick: (RI, View, Int) -> Unit
    ) {
        with(itemView) {
            setOnClickListener { onItemClick(item, adapterPosition) }
            bindItem(item)
        }
        setOnViewClick(onViewClick)
    }

    private fun setOnViewClick(onViewClick: ((RI, View, Int) -> Unit)): BaseViewHolder<RI> {
        this.onViewClick = onViewClick
        return this
    }

}
