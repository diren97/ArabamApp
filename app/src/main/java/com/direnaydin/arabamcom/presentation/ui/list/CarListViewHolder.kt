package com.direnaydin.arabamcom.presentation.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.direnaydin.arabamcom.databinding.ItemCarListBinding
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.presentation.util.ItemClickListener

class CarListViewHolder(private val binding: ItemCarListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(carList: CarItem?, listener: ItemClickListener) {
        binding.dataHolder = carList
        binding.listener = listener
        binding.executePendingBindings()
    }
}