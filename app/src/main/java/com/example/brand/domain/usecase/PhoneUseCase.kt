package com.example.brand.domain.usecase

import com.example.brand.domain.repo.IPhoneRepo
import com.example.brand.ui.util.ApiCode
import javax.inject.Inject

class PhoneUseCase @Inject constructor(private val iPhoneRepo: IPhoneRepo) {
    suspend fun getPhoneUseCase() = iPhoneRepo.getPhoneDomainModel()
    suspend fun execute(phoneName: String): ApiCode<Unit> {
        if (phoneName != "i" || phoneName != "s") {
            return ApiCode.NotFound(message = "Not Found", error = 404)
        }
        return iPhoneRepo.getPhoneName(phoneName)
    }
}