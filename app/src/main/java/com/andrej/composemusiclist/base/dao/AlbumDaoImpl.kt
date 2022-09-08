package com.andrej.composemusiclist.base.dao

import com.andrej.composemusiclist.base.database.RealmDB
import com.andrej.composemusiclist.base.model.realm.AlbumRealm
import io.realm.RealmResults
import io.realm.kotlin.toFlow
import kotlinx.coroutines.flow.Flow

class AlbumDaoImpl : AlbumDao {

    override fun loadMostPlayedAlbums(): RealmResults<AlbumRealm> {
        return RealmDB.realmInstance().where(AlbumRealm::class.java).findAll()
    }

    override suspend fun saveMostPlayedAlbums(albumList: List<AlbumRealm>) {
        RealmDB.realmInstance().executeTransaction {
            it.insertOrUpdate(albumList)
        }
    }

    override suspend fun getAlbumById(albumId: String): Flow<AlbumRealm?> {
        return RealmDB.realmInstance().where(AlbumRealm::class.java).equalTo("id", albumId).findFirst().toFlow()
    }

    override suspend fun observeAlbums(): Flow<RealmResults<AlbumRealm>> {
        return RealmDB.realmInstance().where(AlbumRealm::class.java).findAll().toFlow()
    }
}