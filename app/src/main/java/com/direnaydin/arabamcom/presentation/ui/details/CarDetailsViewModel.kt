package com.direnaydin.arabamcom.presentation.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.direnaydin.arabamcom.network.model.CarDetail
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
        _carDetailItem.postValue(Resource.loading(null))
        savedStateHandle.get<Int>(CarDetailsFragment.KEY_CAR_ID)?.let {
            getCarDetail(it)
        } ?: kotlin.run {
            _carDetailItem.postValue(Resource.error("Error Data", null))
            // null olduğu durumda davranış olmalı.
        }
    }

    private fun getCarDetail(carId: Int){
        viewModelScope.launch {
            carRepository.getCarDetail(carId).let {
                Log.d("deneme1", "url : ${it.photos}")
                _carDetailItem.postValue(Resource.success(it))
            }
        }
    }
}