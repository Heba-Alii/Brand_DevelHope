package com.example.brand.ui.di

import com.example.brand.data.dataSource.remote.ApiService
import com.example.brand.data.dataSource.remote.PhoneRemoteDataSource
import com.example.brand.data.repo.RepoImpl
import com.example.brand.domain.repo.IPhoneRepo
import com.example.brand.domain.usecase.PhoneUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepo(api: PhoneRemoteDataSource): IPhoneRepo {
        return RepoImpl(api)
    }

    @Provides
    fun provideUseCase(iPhoneRepo: IPhoneRepo): PhoneUseCase {
        return PhoneUseCase(iPhoneRepo)
    }
}