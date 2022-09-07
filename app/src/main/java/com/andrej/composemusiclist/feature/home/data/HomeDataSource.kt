package com.andrej.composemusiclist.feature.home.data

import com.andrej.composemusiclist.base.model.data.DataResult
import com.andrej.composemusiclist.feature.home.model.HomeDataModel

interface HomeDataSource {
    suspend fun getMostPlayedAlbums(): DataResult<HomeDataModel>
}