package com.direnaydin.arabamcom.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.network.remote.api.CarService
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.presentation.ui.list.adapter.CarListPaging
import com.direnaydin.arabamcom.repository.CarRepository
import com.direnaydin.arabamcom.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val carRepository: CarRepository, private val carService: CarService) :
    BaseViewModel() {

    private val _carList = MutableLiveData<Resource<Car>>()
    val carList1: LiveData<Resource<Car>> get() = _carList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _carList.postValue(Resource.loading(null))
            delay(2000)
            getCarData()
            _carList.postValue(Resource.success(null))
        }
    }

    val carList = getCarData()

    private fun getCarData(): LiveData<PagingData<CarItem>> {
        return Pager(PagingConfig(pageSize = 10)) {
            CarListPaging(carRepository)
        }.liveData.cachedIn(viewModelScope)
    }
}