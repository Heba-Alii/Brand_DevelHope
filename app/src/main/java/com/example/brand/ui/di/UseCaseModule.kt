package com.example.brand.ui.di

import com.example.brand.domain.repo.IPhoneRepo
import com.example.brand.domain.usecase.PhoneUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(iPhoneRepo: IPhoneRepo): PhoneUseCase {
        return PhoneUseCase(iPhoneRepo)
    }
}