package com.direnaydin.arabamcom.utils

import android.content.Context
import android.content.res.Resources
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:loadUrlImage")
fun ImageView.loadUrlImage(url: String?) {
    val newUrl = url?.replace("{0}", "800x600")
    Glide.with(this).load(newUrl).into(this)
}
