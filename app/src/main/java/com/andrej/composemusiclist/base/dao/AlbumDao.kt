package com.andrej.composemusiclist.base.dao

import com.andrej.composemusiclist.base.model.realm.AlbumRealm
import io.realm.RealmResults
import kotlinx.coroutines.flow.Flow

interface AlbumDao {

    fun loadMostPlayedAlbums(): RealmResults<AlbumRealm>
    suspend fun saveMostPlayedAlbums(albumList: List<AlbumRealm>)
    suspend fun getAlbumById(albumId: String): Flow<AlbumRealm?>
    suspend fun observeAlbums(): Flow<RealmResults<AlbumRealm>>
}