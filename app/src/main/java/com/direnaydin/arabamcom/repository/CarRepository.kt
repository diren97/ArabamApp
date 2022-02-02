package com.direnaydin.arabamcom.repository

import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarDetail
import io.reactivex.Single

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