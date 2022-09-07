package com.andrej.composemusiclist

import android.app.Application
import com.andrej.composemusiclist.base.database.RealmDB
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // initialize Realm
        RealmDB.init(this)
    }

}