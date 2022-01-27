package com.direnaydin.arabamcom.presentation.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.presentation.ui.BaseViewModel
import com.direnaydin.arabamcom.repository.CarRepository
import com.direnaydin.arabamcom.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val carRepository: CarRepository) : BaseViewModel() {

    private val _users = MutableLiveData<Resource<Car>>()
    val users: LiveData<Resource<Car>> get() = _users


    fun dataFetct() {

        viewModelScope.launch {
            Log.d("test","Burada 1")

            _users.postValue(Resource.loading(null))

                carRepository.getCars(1,0,null,null,null,null, null,10).let {
                    Log.d("test","Burada ${it.size}")
                 _users.postValue(Resource.success(it))

                }

        }
    }
}