package com.direnaydin.arabamcom.presentation.ui.fullCarImage

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarImageBinding
import com.direnaydin.arabamcom.presentation.ui.base.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.utils.Status
import com.direnaydin.arabamcom.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarImageFragment :
    BaseFragment<FragmentCarImageBinding, BaseViewModel>(R.layout.fragment_car_image) {

    override val viewModel by viewModels<CarImageViewModel>()

    override fun bind(view: View) = FragmentCarImageBinding.bind(view)

    override fun initUserInterface() {
    }

    override fun initObservers() {
        viewModel.photoUrl.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> showProgress()
                Status.SUCCESS -> {
                    val sliderAdapter =
                        it.data?.let { FullImageSliderAdapter(requireContext(), it) }
                    binding.carFullImgViewPager.adapter = sliderAdapter
                    hideProgress()
                }
                Status.ERROR -> {
                    it.message?.let {
                        showSnackBar(this@CarImageFragment, it)
                    }
                }
            }
        })

    }
}