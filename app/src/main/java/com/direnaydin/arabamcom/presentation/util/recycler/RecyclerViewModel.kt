package com.direnaydin.arabamcom.presentation.util.recycler

import androidx.annotation.ColorRes
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.common.interfaces.RecyclerItem


sealed class RecyclerViewModel : RecyclerItem {
    data class CarListItem(val carImgView: String, val carFeaturesTxt: String, val cityNameTxt: String, val townTxt: String, val priceTxt: String, ) : RecyclerViewModel() {
        override val layoutId: Int = R.layout.item_car_list
        override val id: Int = 0
    }
}