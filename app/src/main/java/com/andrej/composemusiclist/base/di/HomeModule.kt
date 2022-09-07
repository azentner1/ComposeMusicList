package com.andrej.composemusiclist.base.di

import com.andrej.composemusiclist.feature.home.api.HomeApiService
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
object HomeModule {

    @Singleton
    @Provides
    fun providesHomeDataSource(
        homeApiService: HomeApiService,
        homeDataMapper: HomeDataMapper
    ): HomeDataSource =
        HomeDataSourceImpl(homeApiService, homeDataMapper)
}