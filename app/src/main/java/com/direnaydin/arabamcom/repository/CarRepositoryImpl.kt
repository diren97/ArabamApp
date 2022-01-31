package com.direnaydin.arabamcom.repository

import com.direnaydin.arabamcom.network.remote.api.CarService
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarDetail
import io.reactivex.Single
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(private val apiService: CarService) : CarRepository {
    override  fun getCars(
        sort: Int,
        sortDirection: Int,
        minDate: String?,
        maxDate: String?,
        minYear: Int?,
        maxYear: Int?,
        skip: Int?,
        take: Int
    ): Single<Car> {
        return apiService.getCars(sort, sortDirection,minDate,maxDate,minYear,maxYear,skip, take)
    }

    override suspend fun getCarDetail(id: Int): CarDetail {
        return apiService.getCarDetail(id)
    }

}