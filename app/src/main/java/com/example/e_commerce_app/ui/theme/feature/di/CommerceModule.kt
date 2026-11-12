package com.example.e_commerce_app.ui.theme.feature.di

import com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.remote.home.HomeRemoteDataSource
import com.example.e_commerce_app.ui.theme.feature.commerce.data.dataSources.remote.home.HomeRemoteDataSourceImpl
import com.example.e_commerce_app.ui.theme.feature.commerce.data.repository.HomeRepositoryImpl
import com.example.e_commerce_app.ui.theme.feature.commerce.domain.repositories.home.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent ::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
    @Binds
    abstract fun bindHomeRemoteDataSource(
        homeRemoteDataSourceImpl: HomeRemoteDataSourceImpl
    ): HomeRemoteDataSource
}