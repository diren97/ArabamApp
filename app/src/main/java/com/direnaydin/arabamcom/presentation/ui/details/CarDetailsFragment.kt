package com.direnaydin.arabamcom.presentation.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarDetailsBinding
import com.direnaydin.arabamcom.presentation.ui.base.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.presentation.util.OnClickListener
import com.direnaydin.arabamcom.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarDetailsFragment :
    BaseFragment<FragmentCarDetailsBinding, BaseViewModel>(R.layout.fragment_car_details), OnClickListener {

    override val viewModel by viewModels<CarDetailsViewModel>()

    override fun bind(view: View) = FragmentCarDetailsBinding.bind(view)

    override fun initUserInterface() {
    }

    override fun initObservers() {

        viewModel.carDetailItem.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.LOADING -> showProgress()
                Status.SUCCESS -> {
                    val sliderAdapter = it.data?.photos?.let { ImageSliderAdapter(requireContext(), it) }
                    binding.carDetailImgViewPager.adapter = sliderAdapter
                    binding.sliderNumberTxt.text =
                        binding.carDetailImgViewPager.currentItem.plus(1).toString()
                    binding.detailItem = it.data
                    hideProgress()
                }
                Status.ERROR -> {
                    // error snackbar use on view
                }
            }
        })

        binding.carDetailImgViewPager.addOnPageChangeListener(object :
            ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                binding.sliderNumberTxt.text = position.plus(1).toString()
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    companion object {
        const val KEY_CAR_ID = "carId"
        const val KEY_PHOTO_URL = "photoUrl"
    }

    override fun onItemClick(photos: List<out String>) {
          navigate(R.id.toCarImageFragment, Bundle().apply {
            putStringArray(KEY_PHOTO_URL, photos.toTypedArray())
        })
    }
}