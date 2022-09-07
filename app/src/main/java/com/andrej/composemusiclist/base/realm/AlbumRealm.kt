package com.andrej.composemusiclist.base.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class AlbumRealm : RealmObject() {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var artistName = ""
    var artworkUrl = ""

}