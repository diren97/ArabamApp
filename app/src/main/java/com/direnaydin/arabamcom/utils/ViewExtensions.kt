package com.direnaydin.arabamcom.utils

import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

@BindingAdapter("app:loadUrlImage")
fun ImageView.loadUrlImage(url: String?) {
    val newUrl = url?.replace("{0}", "800x600")
    val newUrl1 = url?.replace("{0}", "1920x1080")

    Glide.with(this@loadUrlImage)
        .load(newUrl1)
        .transition(DrawableTransitionOptions.withCrossFade())
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Handler(Looper.getMainLooper()).post {
                    Glide.with(this@loadUrlImage)
                        .load(newUrl)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(this@loadUrlImage)
                }
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }
        })
        .into(this)
}

fun Fragment.showSnackBar(fragment: Fragment, text: String) {
    SnackBarBuilder(fragment, text).show()
}
