package com.direnaydin.arabamcom.presentation.ui.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.direnaydin.arabamcom.utils.CarDialogProgress
import com.direnaydin.arabamcom.utils.autoCleared

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(layoutId: Int) :
    Fragment(layoutId) {

    abstract val viewModel: VM?
    open var binding  by autoCleared<VB>()
    abstract fun bind(view: View): VB

    protected val navController by lazy { findNavController() }

    private var progressBar: CarDialogProgress? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = bind(view)

        initUserInterface()
        initObservers()
        initProgressBar()
    }

    abstract fun initUserInterface()

    abstract fun initObservers()

    open fun navigate(actionId: Int, bundle: Bundle? = null) {
        navController.navigate(actionId, bundle)
    }

    fun showProgress() {
        progressBar?.show()
        activity?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    fun hideProgress() {
        progressBar?.dismiss()
        activity?.window?.clearFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    private fun initProgressBar() {
        context?.let {
            progressBar = CarDialogProgress(it)
        }
    }
}