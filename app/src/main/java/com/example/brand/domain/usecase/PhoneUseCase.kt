package com.example.brand.domain.usecase

import com.example.brand.domain.repo.IPhoneRepo

class PhoneUseCase(private val iPhoneRepo: IPhoneRepo) {
    suspend fun getPhoneUseCase() = iPhoneRepo.getPhoneDomainModel()
}