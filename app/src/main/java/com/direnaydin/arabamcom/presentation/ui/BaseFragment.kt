package com.direnaydin.arabamcom.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(layoutId: Int) : Fragment(layoutId) {

    abstract val viewModel: VM?
    open var binding: VB? = null
    abstract fun bind(view: View): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}