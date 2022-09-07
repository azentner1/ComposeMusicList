package com.andrej.composemusiclist.feature.home.dao

import com.andrej.composemusiclist.base.database.RealmDB
import com.andrej.composemusiclist.base.realm.AlbumRealm
import io.realm.RealmResults

class AlbumDaoImpl : AlbumDao {

    override fun loadMostPlayedAlbums(): RealmResults<AlbumRealm> {
        return RealmDB.realmInstance().where(AlbumRealm::class.java).findAll()
    }

    override suspend fun saveMostPlayedAlbums(albumList: List<AlbumRealm>) {
        RealmDB.realmInstance().executeTransaction {
            it.insertOrUpdate(albumList)
        }
    }
}