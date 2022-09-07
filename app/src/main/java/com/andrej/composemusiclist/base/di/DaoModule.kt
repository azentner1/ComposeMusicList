package com.andrej.composemusiclist.base.di

import com.andrej.composemusiclist.feature.home.api.HomeApiService
import com.andrej.composemusiclist.feature.home.dao.AlbumDao
import com.andrej.composemusiclist.feature.home.dao.AlbumDaoImpl
import com.andrej.composemusiclist.feature.home.data.HomeDataSource
import com.andrej.composemusiclist.feature.home.data.HomeDataSourceImpl
import com.andrej.composemusiclist.feature.home.mapper.HomeDataMapper
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