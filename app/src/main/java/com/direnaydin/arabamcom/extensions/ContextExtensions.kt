package com.direnaydin.arabamcom.extensions

import android.content.Context
import android.content.res.Resources

fun Context?.getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun Context?.getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}