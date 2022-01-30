package com.direnaydin.arabamcom.presentation.ui.details

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarDetailsBinding
import com.direnaydin.arabamcom.presentation.ui.base.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarDetailsFragment :
    BaseFragment<FragmentCarDetailsBinding, BaseViewModel>(R.layout.fragment_car_details) {

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
                    //binding.itemCarProperty.valueKmTxt.text = it.data!!.properties[0].value
                    binding.itemCarProperty.valueColorTxt.text = it.data!!.properties[1].value
                    binding.itemCarProperty.valueYearTxt.text = it.data.properties[2].value
                    binding.itemCarProperty.valueGearTxt.text = it.data.properties[3].value
                    binding.itemCarProperty.valueFuelTxt.text = it.data.properties[4].value
                    binding.itemCarProperty.valueNameSurnameTxt.text = it.data.userInfo.nameSurname
                    binding.itemCarProperty.valuePhoneTxt.text = it.data.userInfo.phone
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
    }
}