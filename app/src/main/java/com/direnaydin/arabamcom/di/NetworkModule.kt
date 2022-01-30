package com.direnaydin.arabamcom.di

import com.direnaydin.arabamcom.network.remote.api.CarService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun serviceProvider(retrofit: Retrofit) : CarService = retrofit.create(CarService::class.java)

}