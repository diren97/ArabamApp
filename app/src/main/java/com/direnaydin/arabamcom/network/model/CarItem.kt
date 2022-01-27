package com.direnaydin.arabamcom.network.model

data class CarItem(
    val category: Category,
    val date: String,
    val dateFormatted: String,
    val id: Int,
    val location: Location,
    val modelName: String,
    val photo: String,
    val price: Int,
    val priceFormatted: String,
    val properties: List<Property>,
    val title: String
)