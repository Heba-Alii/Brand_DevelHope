package com.example.brand.ui.di

import com.example.brand.data.dataSource.remote.ApiService
import com.example.brand.data.dataSource.remote.PhoneRemoteDataSource
import com.example.brand.data.repo.RepoImpl
import com.example.brand.domain.repo.IPhoneRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(api: PhoneRemoteDataSource): IPhoneRepo {
        return RepoImpl(api)
    }
}