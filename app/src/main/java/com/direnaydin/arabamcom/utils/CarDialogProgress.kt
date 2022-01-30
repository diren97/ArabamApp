package com.direnaydin.arabamcom.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.direnaydin.arabamcom.R

class CarDialogProgress(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_car_loading_progress)
        window?.setBackgroundDrawableResource(R.color.transparent)
        setCancelable(false)
    }
}