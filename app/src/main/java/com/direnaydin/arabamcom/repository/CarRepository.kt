package com.direnaydin.arabamcom.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarDetail
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.network.model.Sort
import io.reactivex.Single
import javax.inject.Singleton

interface CarRepository {
     fun getCars(
        sort: Int,
        sortDirection: Int,
        minDate: String?,
        maxDate: String?,
        minYear: Int?,
        maxYear: Int?,
        skip: Int?,
        take: Int
    ): Single<Car>

    suspend fun getCarDetail(id: Int): CarDetail
}