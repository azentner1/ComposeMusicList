package com.andrej.composemusiclist.base.mapper.genre

import com.andrej.composemusiclist.base.mapper.EntityMapper
import com.andrej.composemusiclist.base.model.domain.Genre
import com.andrej.composemusiclist.base.model.realm.GenreRealm
import io.realm.RealmList
import javax.inject.Inject

class GenreDataMapper @Inject constructor(

) : EntityMapper<RealmList<GenreRealm>?, List<Genre>> {
    override fun mapFromEntity(entity: RealmList<GenreRealm>?): List<Genre> {
       return entity?.map {
           Genre(
               id = it.id,
               name = it.name,
               url = it.url
           )
       } ?: listOf()
    }

    override fun mapToEntity(model: List<Genre>): RealmList<GenreRealm> {
        val genresList = RealmList<GenreRealm>()
        model.mapNotNull {
            if (it.name.toLowerCase().trim() == EXCLUDED_GENRE) {
                return@mapNotNull null
            }
            val genre = GenreRealm().apply {
                id = it.id
                name = it.name
                url = it.url
            }
            genresList.add(genre)
        }
        return genresList
    }
}

private const val EXCLUDED_GENRE = "music"