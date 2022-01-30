package com.direnaydin.arabamcom.presentation.ui.details

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarDetailsBinding
import com.direnaydin.arabamcom.presentation.ui.base.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarDetailsFragment :
    BaseFragment<FragmentCarDetailsBinding, BaseViewModel>(R.layout.fragment_car_details) {

    override val viewModel by viewModels<CarDetailsViewModel>()

    override fun bind(view: View) = FragmentCarDetailsBinding.bind(view)

    override fun initUserInterface() {
    }

    @SuppressLint("SetTextI18n")
    override fun initObservers() {

        viewModel.carDetailItem.observe(viewLifecycleOwner, Observer {


           /* val sliderAdapter =
                it.data?.photo?.let { ImageSliderAdapter(requireContext(), it) }
            binding.detailFragmentTitle.text = it.data?.title
            binding.detailFragmentCityName.text = it.data?.location?.cityName + "-" + it.data?.location?.townName
            binding.detailFragmentCategory.text = it.data?.category?.name
            binding.detailFragmentUserName.text = it.data?.modelName*/
        })
    }
    companion object{
        const val KEY_CAR_ITEM = "item"
    }
}