package com.direnaydin.arabamcom.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.repository.CarRepository
import com.direnaydin.arabamcom.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val carRepository: CarRepository) :
    BaseViewModel() {

    private val _carList = MutableLiveData<Resource<Car>>()
    val carList: LiveData<Resource<Car>> get() = _carList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _carList.postValue(Resource.loading(null))
            carRepository.getCars(1, 0, null, null, null, null, null, 10).let {
                _carList.postValue(Resource.success(it))
            }
        }
    }
}