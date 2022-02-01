package com.direnaydin.arabamcom.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.presentation.ui.list.adapter.CarListPaging
import com.direnaydin.arabamcom.repository.CarRepository
import com.direnaydin.arabamcom.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val carRepository: CarRepository) :
    BaseViewModel() {

    private val _loadingState = MutableLiveData<Resource<Boolean>>()
    val loadingState: LiveData<Resource<Boolean>> get() = _loadingState

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _loadingState.postValue(Resource.success(true))
            delay(2000)
            carList
            _loadingState.postValue(Resource.success(false))
        }
    }

    val carList = getCarData()

    private fun getCarData(): LiveData<PagingData<CarItem>> {
        return Pager(PagingConfig(pageSize = 10)) {
            CarListPaging(carRepository)
        }.liveData.cachedIn(viewModelScope)
    }
}