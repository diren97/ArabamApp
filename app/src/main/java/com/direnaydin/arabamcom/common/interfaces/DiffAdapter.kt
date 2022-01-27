package com.direnaydin.arabamcom.common.interfaces

import androidx.recyclerview.widget.DiffUtil

interface DiffAdapter {

    fun <RI : RecyclerItem> androidx.recyclerview.widget.RecyclerView.Adapter<*>.notifyDiff(
            oldList: List<RI>,
            newList: List<RI>,
            compare: (RI, RI) -> Boolean = { o, n -> o.id == n.id }
    ) {
        val diff = DiffUtil.calculateDiff(
                object : DiffUtil.Callback() {
                    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                            compare(oldList[oldItemPosition], newList[newItemPosition])

                    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
                            oldList[oldItemPosition] == newList[newItemPosition]

                    override fun getOldListSize() = oldList.size

                    override fun getNewListSize() = newList.size

                }
        )

        diff.dispatchUpdatesTo(this)
    }
}
