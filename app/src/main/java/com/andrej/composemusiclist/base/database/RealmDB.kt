package com.andrej.composemusiclist.base.database

import android.content.Context
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration

object RealmDB {

    private const val DATABASE_NAME = "music.realm"
    private const val SCHEMA_VERSION = 1L

    private lateinit var realmConfig: RealmConfiguration

    fun init(context: Context) {
        try {
            Realm.init(context)
            realmConfig =
                RealmConfiguration.Builder()
                    .name(DATABASE_NAME)
                    .schemaVersion(SCHEMA_VERSION)
                    .build()
        } catch (e: Exception) { }
    }

    fun realmInstance(): Realm {
        return Realm.getInstance(realmConfig)
    }
}