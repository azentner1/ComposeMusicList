package com.andrej.composemusiclist.feature.home.dao

import com.andrej.composemusiclist.base.realm.AlbumRealm
import io.realm.RealmResults

interface AlbumDao {

    fun loadMostPlayedAlbums(): RealmResults<AlbumRealm>
    suspend fun saveMostPlayedAlbums(albumList: List<AlbumRealm>)
}