package com.direnaydin.arabamcom.presentation.ui.fullCarImage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.direnaydin.arabamcom.presentation.ui.base.BaseViewModel
import com.direnaydin.arabamcom.presentation.ui.details.CarDetailsFragment
import com.direnaydin.arabamcom.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CarImageViewModel @Inject constructor(savedStateHandle: SavedStateHandle) :
    BaseViewModel() {

    private val _photoUrl = MutableLiveData<Resource<List<String>>>()
    val photoUrl: LiveData<Resource<List<String>>> get() = _photoUrl

    init {
        _photoUrl.postValue(Resource.loading(null))
        savedStateHandle.get<List<String>>(CarDetailsFragment.KEY_PHOTO_URL)?.let {
            _photoUrl.postValue(Resource.success(it))
        } ?: kotlin.run {
            _photoUrl.postValue(Resource.error("Error Data", null))
        }
    }

}