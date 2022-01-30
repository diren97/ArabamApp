package com.direnaydin.arabamcom.di

import com.direnaydin.arabamcom.network.remote.api.CarService
import com.direnaydin.arabamcom.repository.CarRepository
import com.direnaydin.arabamcom.repository.CarRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RemoteDataModule {

    @Provides
    fun provideCarRepository(carService: CarService): CarRepository{
        return CarRepositoryImpl(carService)
    }
}