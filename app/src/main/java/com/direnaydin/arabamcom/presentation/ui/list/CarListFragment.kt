package com.direnaydin.arabamcom.presentation.ui.list


import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.FragmentCarListBinding
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.presentation.ui.BaseFragment
import com.direnaydin.arabamcom.presentation.util.ItemClickListener
import androidx.navigation.fragment.findNavController
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

        viewModel.carlists.observe(viewLifecycleOwner, Observer {
            carListAdapter.originalList = it
        })

    }

    private fun initItemClickListener() = object : ItemClickListener {
        override fun onItemClick(item: CarItem) {
            findNavController().navigate(CarListFragmentDirections.toCarDetailsFragment())
        }
    }

}