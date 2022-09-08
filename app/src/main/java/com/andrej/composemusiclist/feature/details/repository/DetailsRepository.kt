package com.andrej.composemusiclist.feature.details.repository

import com.andrej.composemusiclist.base.dao.AlbumDao
import com.andrej.composemusiclist.base.mapper.album.AlbumDataMapper
import com.andrej.composemusiclist.base.model.domain.Album
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val albumDao: AlbumDao,
    private val albumDataMapper: AlbumDataMapper
) {
    suspend fun getAlbumById(albumId: String): Flow<Album> {
        return albumDao.getAlbumById(albumId).map {
            albumDataMapper.mapFromEntity(it)
        }
    }
}