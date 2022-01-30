package com.direnaydin.arabamcom.presentation.util

import com.direnaydin.arabamcom.network.model.CarItem

interface ItemClickListener {
    fun onItemClick(car: CarItem)
}