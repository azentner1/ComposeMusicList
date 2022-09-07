package com.andrej.composemusiclist.feature.home.mapper

import com.andrej.composemusiclist.base.mapper.EntityMapper
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.realm.AlbumRealm
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import com.andrej.composemusiclist.feature.home.model.HomeResponse
import javax.inject.Inject

class HomeDataMapper @Inject constructor() : EntityMapper<HomeResponse?, HomeDataModel> {

    override fun mapFromEntity(entity: HomeResponse?): HomeDataModel {
        return HomeDataModel(
            mostPlayedAlbumsList = entity?.feed?.results ?: listOf()
        )
    }

    fun mapToRealmEntity(mostPlayedAlbumsList: List<Album>): List<AlbumRealm> {
        return mostPlayedAlbumsList.map {
            AlbumRealm().apply {
                id = it.id
                name = it.name
                artistName = it.artistName
                artworkUrl = it.artworkUrl
            }
        }
    }

}