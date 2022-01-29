package com.direnaydin.arabamcom.presentation.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarDetailsBinding
import com.direnaydin.arabamcom.presentation.ui.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.BaseViewModel


class CarDetailsFragment :
    BaseFragment<FragmentCarDetailsBinding, BaseViewModel>(R.layout.fragment_car_details) {


    override val viewModel: BaseViewModel?
        get() = null

    private val navArgs by navArgs<CarDetailsFragmentArgs>()

    override fun bind(view: View) = FragmentCarDetailsBinding.bind(view)


    override fun initUserInterface() {
    }

    override fun initObservers() = Unit
}