package com.direnaydin.arabamcom.presentation.ui.list


import android.view.View
import androidx.fragment.app.viewModels
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarListBinding
import com.direnaydin.arabamcom.presentation.ui.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarListFragment :
    BaseFragment<FragmentCarListBinding, CarListViewModel>(R.layout.fragment_car_list) {

    override val viewModel by viewModels<CarListViewModel>()
    override fun bind(view: View): FragmentCarListBinding = FragmentCarListBinding.bind(view)


}