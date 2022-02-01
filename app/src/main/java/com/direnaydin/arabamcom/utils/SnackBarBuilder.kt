package com.direnaydin.arabamcom.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.direnaydin.arabamcom.R
import com.google.android.material.snackbar.Snackbar

class SnackBarBuilder(fragment: Fragment, text: String) {
    private var snackBar: Snackbar? = null

    init {
        createSnackbar(fragment.view, text)
    }

    private fun createSnackbar(targetView: View?, text: String) {
        targetView?.let { targetView ->
            targetView.context?.let { safeContext ->
                with(Snackbar.make(targetView, text, Snackbar.LENGTH_LONG)) {
                    val snackBarTextView: TextView = view.findViewById(R.id.snackbar_text)
                    snackBarTextView.setTextColor(
                        ContextCompat.getColor(
                            safeContext, R.color.white
                        )
                    )
                    view.setBackgroundColor(
                        ContextCompat.getColor(
                            safeContext, R.color.red
                        )
                    )
                    snackBar = this
                }
            }
        }
    }

    fun show() {
        snackBar?.show()
    }
}