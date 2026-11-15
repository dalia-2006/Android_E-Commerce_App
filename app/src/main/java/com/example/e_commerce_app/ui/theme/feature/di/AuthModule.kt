package com.example.e_commerce_app.ui.theme.feature.di

import com.example.e_commerce_app.ui.theme.feature.Auth.data.dataSources.remote.AuthRemoteDataSource
import com.example.e_commerce_app.ui.theme.feature.Auth.data.dataSources.remote.AuthRemoteDataSourceImpl
import com.example.e_commerce_app.ui.theme.feature.Auth.data.repository.AuthRepositoryImpl
import com.example.e_commerce_app.ui.theme.feature.Auth.domain.repositories.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindAuthRemoteDataSource(
        authRemoteDataSourceImpl: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource
}
