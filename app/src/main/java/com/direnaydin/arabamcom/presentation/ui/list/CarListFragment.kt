package com.direnaydin.arabamcom.presentation.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarListBinding
import com.direnaydin.arabamcom.presentation.ui.base.BaseFragment
import com.direnaydin.arabamcom.presentation.ui.details.CarDetailsFragment
import com.direnaydin.arabamcom.presentation.ui.list.adapter.CarListAdapter
import com.direnaydin.arabamcom.presentation.util.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarListFragment :
    BaseFragment<FragmentCarListBinding, CarListViewModel>(R.layout.fragment_car_list) {

    override val viewModel by viewModels<CarListViewModel>()
    private lateinit var carListAdapter: CarListAdapter

    override fun bind(view: View): FragmentCarListBinding = FragmentCarListBinding.bind(view)

    override fun initUserInterface() {
        carListAdapter = CarListAdapter(initItemClickListener())
    }

    override fun initObservers() {
        hideProgress()

        viewModel.loadingState.observe(viewLifecycleOwner, Observer {
            if (it.data == true)
                showProgress()
            else
                hideProgress()
        })

        viewModel.carList.observe(viewLifecycleOwner, Observer {
            binding.rvCarList.adapter = carListAdapter.apply {
                submitData(lifecycle, it)
            }
        })
    }

    private fun initItemClickListener() = object : ItemClickListener {
        override fun onItemClick(carId: Int) {
            navigate(R.id.toCarDetailsFragment, Bundle().apply {
                putInt(CarDetailsFragment.KEY_CAR_ID, carId)
            })
        }
    }
}