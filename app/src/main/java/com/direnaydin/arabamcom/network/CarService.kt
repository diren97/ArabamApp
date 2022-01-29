package com.direnaydin.arabamcom.network

import com.direnaydin.arabamcom.constants.ApplicationConstants
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface CarService {
    @GET(ApplicationConstants.LISTING_API_ENDPOINT)
    suspend fun getCars(
        @Query("sort") sort: Int = 1,
        @Query("sortDirection") sortDirection: Int = 0,
        @Query("minDate") minDate: String?,
        @Query("maxDate") maxDate: String?,
        @Query("minYear") minYear: Int?,
        @Query("maxYear") maxYear: Int?,
        @Query("skip") skip: Int?,
        @Query("take") take: Int = 10
    ): Car

    @GET(ApplicationConstants.DETAIL_API_ENDPOINT)
    suspend fun getCarDetail(
        @Query("id") id: Int
    ): CarDetail
}