package com.andrej.composemusiclist.base.mapper.album

import com.andrej.composemusiclist.base.mapper.EntityMapper
import com.andrej.composemusiclist.base.mapper.genre.GenreDataMapper
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.model.realm.AlbumRealm
import io.realm.RealmResults
import javax.inject.Inject

class AlbumDataMapper @Inject constructor(
    private val genreDataMapper: GenreDataMapper
) : EntityMapper<AlbumRealm?, Album> {

    override fun mapFromEntity(entity: AlbumRealm?): Album {
        return Album(
            id = entity?.id ?: "",
            name = entity?.name ?: "",
            artistName = entity?.artistName ?: "",
            artworkUrl = entity?.artworkUrl ?: "",
            releaseDate = entity?.releaseDate ?: "",
            genres = genreDataMapper.mapFromEntity(entity?.genres)
        )
    }

    override fun mapToEntity(model: Album): AlbumRealm {
        return AlbumRealm().apply {
            id = model.id
            name = model.name
            artistName = model.artistName
            artworkUrl = model.artworkUrl
            releaseDate = model.releaseDate
            genres = genreDataMapper.mapToEntity(model.genres)
        }
    }

    fun mapAlbumsToRealmEntity(albumsList: List<Album>): List<AlbumRealm> {
        return albumsList.map {
            AlbumRealm().apply {
                id = it.id
                name = it.name
                artistName = it.artistName
                artworkUrl = it.artworkUrl
                releaseDate = it.releaseDate
                genres = genreDataMapper.mapToEntity(it.genres)
            }
        }
    }

    fun mapAlbumsFromRealmEntity(resultList: RealmResults<AlbumRealm>): List<Album> {
        return resultList.map {
            Album(
                id = it.id,
                name = it.name,
                artistName = it.artistName,
                artworkUrl = it.artworkUrl,
                releaseDate = it.releaseDate,
                genres = genreDataMapper.mapFromEntity(it.genres)
            )
        }
    }
}