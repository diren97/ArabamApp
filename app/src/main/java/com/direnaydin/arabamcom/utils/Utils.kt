package com.direnaydin.arabamcom.utils

import android.content.Context
import com.direnaydin.arabamcom.extensions.getScreenWidth

object Utils {

    fun getCalculateImageForDeviceSize(context: Context): String {
        return when (context.getScreenWidth().toString()) {
            "90" -> "120"
            "120" -> "160"
            "180" -> "240"
            "435" -> "580"
            "600" -> "800"
            "1080" -> "1920"
            else -> "800"
        }
    }
}