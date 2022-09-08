package com.andrej.composemusiclist.feature.home.mapper

import com.andrej.composemusiclist.base.mapper.EntityMapper
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import com.andrej.composemusiclist.feature.home.model.HomeResponse
import javax.inject.Inject

class HomeDataMapper @Inject constructor() : EntityMapper<HomeResponse?, HomeDataModel> {

    override fun mapFromEntity(entity: HomeResponse?): HomeDataModel {
        return HomeDataModel(
            mostPlayedAlbumsList = entity?.feed?.results ?: listOf()
        )
    }

    override fun mapToEntity(model: HomeDataModel): HomeResponse? {
        TODO("Not yet implemented")
    }
}