package com.andrej.composemusiclist.base.model.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class GenreRealm : RealmObject() {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var url: String = ""
}