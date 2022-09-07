package com.andrej.composemusiclist.feature.home.data

import com.andrej.composemusiclist.base.model.data.DataResult
import com.andrej.composemusiclist.base.model.data.ErrorEntity
import com.andrej.composemusiclist.feature.home.api.HomeApiService
import com.andrej.composemusiclist.feature.home.mapper.HomeDataMapper
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import com.andrej.composemusiclist.feature.home.model.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HomeDataSourceImpl(
    private val homeApiService: HomeApiService,
    private val homeDataMapper: HomeDataMapper
) : HomeDataSource {

    override suspend fun getMostPlayedAlbums(): DataResult<HomeDataModel> {
        return suspendCoroutine {
            homeApiService.fetchMostPlayedAlbums().enqueue(object : Callback<HomeResponse> {

                override fun onResponse(
                    call: Call<HomeResponse>,
                    response: Response<HomeResponse>
                ) {
                    val k = 1
                    println(response.raw().body)
                    if (response.isSuccessful) {
                        it.resume(DataResult.Success(homeDataMapper.mapFromEntity(response.body())))
                    } else {
                        it.resume(DataResult.Error(ErrorEntity.Network))
                    }

                }

                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                    val n = 2
                    it.resume(DataResult.Error(ErrorEntity.Unknown))
                }
            })
        }
    }

}