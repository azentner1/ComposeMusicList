package com.andrej.composemusiclist.feature.home.repository

import com.andrej.composemusiclist.base.database.RealmDB
import com.andrej.composemusiclist.base.model.data.DataResult
import com.andrej.composemusiclist.base.model.data.ErrorEntity
import com.andrej.composemusiclist.base.model.data.UiDataState
import com.andrej.composemusiclist.base.realm.AlbumRealm
import com.andrej.composemusiclist.base.repository.BaseRepository
import com.andrej.composemusiclist.feature.home.dao.AlbumDao
import com.andrej.composemusiclist.feature.home.data.HomeDataSource
import com.andrej.composemusiclist.feature.home.mapper.HomeDataMapper
import com.andrej.composemusiclist.feature.home.model.HomeDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.switchMap
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeDataSource: HomeDataSource,
    private val homeDataMapper: HomeDataMapper,
    private val albumDao: AlbumDao
) : BaseRepository() {

    suspend fun getMostPlayedAlbums(): Flow<UiDataState<HomeDataModel>> {
        return fetchData(
            remote = { homeDataSource.getMostPlayedAlbums() },
            persistData = { data ->
                albumDao.saveMostPlayedAlbums(homeDataMapper.mapToRealmEntity(data.mostPlayedAlbumsList))
            }
        )
    }
}
