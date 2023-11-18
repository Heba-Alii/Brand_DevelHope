package com.example.brand.domain.usecase

import com.example.brand.domain.repo.IPhoneRepo
import javax.inject.Inject

class PhoneUseCase @Inject constructor(private val iPhoneRepo: IPhoneRepo) {
    suspend fun getPhoneUseCase() = iPhoneRepo.getPhoneDomainModel()
}