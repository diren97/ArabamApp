package com.direnaydin.arabamcom.presentation.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.direnaydin.arabamcom.network.model.CarDetail
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.repository.CarRepository
import com.direnaydin.arabamcom.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle, private val carRepository: CarRepository) :
    BaseViewModel() {


    private val _carDetailItem = MutableLiveData<Resource<CarDetail>>()
    val carDetailItem: LiveData<Resource<CarDetail>> get() = _carDetailItem

    init {
        fetchData()
        _carDetailItem.postValue(Resource.loading(null))
        savedStateHandle.get<CarDetail>(CarDetailsFragment.KEY_CAR_ITEM.toString())?.let {
            _carDetailItem.postValue(Resource.success(it))
        }
    }

    private fun fetchData() {
        viewModelScope.launch {
            _carDetailItem.postValue(Resource.loading(null))
            carRepository.getCarDetail(CarDetailsFragment.KEY_CAR_ITEM).let {
                _carDetailItem.postValue(Resource.success(it))
            }
        }
    }
}