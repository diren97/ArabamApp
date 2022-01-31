package com.direnaydin.arabamcom.presentation.ui.list.adapter

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.direnaydin.arabamcom.network.model.Car
import com.direnaydin.arabamcom.network.model.CarItem
import com.direnaydin.arabamcom.repository.CarRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CarListPaging(private val carRepository: CarRepository) :
    RxPagingSource<Int, CarItem>() {

    override fun getRefreshKey(state: PagingState<Int, CarItem>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, CarItem>> {
        val page = params.key ?: 1

        return carRepository.getCars(1, 0, null, null, null, null, page, 10)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, page) }
            .onErrorReturn { LoadResult.Error(it) }

    }


    private fun toLoadResult(data: Car, position: Int): LoadResult<Int, CarItem> {
        return LoadResult.Page(
            data = data,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (data.isEmpty()) null else position + 1
        )
    }
}
