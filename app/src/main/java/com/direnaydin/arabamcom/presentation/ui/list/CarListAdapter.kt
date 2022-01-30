package com.direnaydin.arabamcom.presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.direnaydin.arabamcom.databinding.ItemCarListBinding
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.presentation.util.ItemClickListener

class CarListAdapter(private val listener: ItemClickListener) :
    ListAdapter<CarItem, CarListViewHolder>(ItemDiffCallback()) {
    private lateinit var parentRecyclerView: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        return CarListViewHolder(
            ItemCarListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        parentRecyclerView = recyclerView
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ItemDiffCallback : DiffUtil.ItemCallback<CarItem>() {
        override fun areItemsTheSame(oldItem: CarItem, newItem: CarItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CarItem, newItem: CarItem): Boolean {
            return oldItem == newItem
        }
    }

}