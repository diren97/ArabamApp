package com.direnaydin.arabamcom.presentation.ui.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.extensions.getScreenWidth
import com.direnaydin.arabamcom.utils.Utils
import com.direnaydin.arabamcom.utils.loadUrlImage

class ImageSliderAdapter(private val context: Context, private val photos: List<String>): PagerAdapter() {

    private lateinit var inflater: LayoutInflater

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_image_slider, container, false)
        val image = view.findViewById<ImageView>(R.id.sliderImgView)

        image.loadUrlImage(
            photos[position].replace("{0}", "${Utils.getCalculateImageForDeviceSize(view.context)}x${view.context.getScreenWidth()}")
        )

        container.addView(view)

        return view
    }

    override fun getCount() = photos.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean =
        view == `object` as LinearLayout
}