package com.andrej.composemusiclist.base.model.realm

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class AlbumRealm : RealmObject() {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var artistName: String = ""
    var artworkUrl: String = ""
    var releaseDate: String = ""
    var genres: RealmList<GenreRealm> = RealmList()

}