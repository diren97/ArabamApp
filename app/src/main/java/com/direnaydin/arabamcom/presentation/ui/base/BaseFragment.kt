package com.direnaydin.arabamcom.presentation.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.direnaydin.arabamcom.utils.autoCleared

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(layoutId: Int) :
    Fragment(layoutId) {

    abstract val viewModel: VM?
    open var binding  by autoCleared<VB>()
    abstract fun bind(view: View): VB

    protected val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = bind(view)

        initUserInterface()
        initObservers()
    }

    abstract fun initUserInterface()

    abstract fun initObservers()

    open fun navigate(actionId: Int, bundle: Bundle? = null) {
        navController.navigate(actionId, bundle)
    }
}