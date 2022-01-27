package com.direnaydin.arabamcom.presentation.util.recycler

import android.view.ViewGroup
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.common.viewholders.BaseViewHolder

sealed class RecyclerViewHolder <M : RecyclerViewModel>(open val parent: ViewGroup, open val layoutId: Int) : BaseViewHolder<M>(parent, layoutId){


    class CarList(override val parent: ViewGroup, override val layoutId: Int = LAYOUT_ID) : RecyclerViewHolder<RecyclerViewModel.CarListItem>(parent, layoutId){

        override fun bindItem(item: RecyclerViewModel.CarListItem) {
            with(itemView){

              /*  *//*Glide.with(carImgView).load(800*800).centerCrop()
                             .into(carImgView) = item.carImgView*//*
                carFeaturesTxt.text = item.carFeaturesTxt
                cityNameTxt.text = item.cityNameTxt
                townTxt.text = item.townTxt
                priceTxt.text = item.priceTxt*/
            }
        }

        companion object {
            const val LAYOUT_ID = R.layout.item_car_list
        }


    }

}