package com.andrej.composemusiclist.feature.home.repository

import com.andrej.composemusiclist.base.dao.AlbumDao
import com.andrej.composemusiclist.base.mapper.album.AlbumDataMapper
import com.andrej.composemusiclist.base.model.data.UiDataState
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.repository.BaseRepository
import com.andrej.composemusiclist.feature.home.data.HomeDataSource
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeDataSource: HomeDataSource,
    private val albumDataMapper: AlbumDataMapper,
    private val albumDao: AlbumDao
) : BaseRepository() {

    suspend fun getMostPlayedAlbums(): Flow<UiDataState<HomeDataModel>> {
        return fetchData(
            remote = { homeDataSource.getMostPlayedAlbums() },
            persistData = { data ->
                albumDao.saveMostPlayedAlbums(albumDataMapper.mapAlbumsToRealmEntity(data.mostPlayedAlbumsList))
            }
        )
    }

    suspend fun observeAlbums(): Flow<List<Album>> {
        return albumDao.observeAlbums().map {
            albumDataMapper.mapAlbumsFromRealmEntity(it)
        }
    }
}
