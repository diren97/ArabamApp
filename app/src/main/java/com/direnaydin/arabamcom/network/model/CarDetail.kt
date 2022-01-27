package com.direnaydin.arabamcom.network.model

data class CarDetail(
    val date: String,
    val dateFormatted: String,
    val id: Int,
    val modelName: String,
    val photos: List<String>,
    val price: Int,
    val priceFormatted: String,
    val text: String,
    val title: String,
    val userInfo: UserInfo
)