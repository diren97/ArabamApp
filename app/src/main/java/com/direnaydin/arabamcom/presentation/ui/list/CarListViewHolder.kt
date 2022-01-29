package com.direnaydin.arabamcom.presentation.ui.list

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.direnaydin.arabamcom.databinding.ItemCarListBinding
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.presentation.util.ItemClickListener

class CarListViewHolder(private val binding: ItemCarListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(carList: CarItem, itemClickListener: ItemClickListener) {
        with(binding) {
            //for (i in carList.indices) {

                Glide.with(carImgView).load(carList.photo).centerCrop().into(carImgView)
                carFeaturesTxt.text = carList.modelName
                locationTxt.text = carList.location.cityName + " " + carList.location.townName
                priceTxt.text = carList.price.toString()

                root.setOnClickListener {
                    itemClickListener.onItemClick(carList)
                }
            }
       // }
    }
}