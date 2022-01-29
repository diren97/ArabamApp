package com.direnaydin.arabamcom.repository

import com.direnaydin.arabamcom.network.CarService
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarDetail
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(private val apiService: CarService) : CarRepository {
    override suspend fun getCars(
        sort: Int,
        sortDirection: Int,
        minDate: String?,
        maxDate: String?,
        minYear: Int?,
        maxYear: Int?,
        skip: Int?,
        take: Int
    ): Car {
        return apiService.getCars(sort, sortDirection,minDate,maxDate,minYear,maxYear,skip, take)
    }

    override suspend fun getCarDetail(id: Int): CarDetail {
        return apiService.getCarDetail(id)
    }

}