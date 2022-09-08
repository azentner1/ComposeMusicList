package com.andrej.composemusiclist.base.di

import com.andrej.composemusiclist.base.dao.AlbumDao
import com.andrej.composemusiclist.base.dao.AlbumDaoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun providesAlbumDao(): AlbumDao =
        AlbumDaoImpl()
}