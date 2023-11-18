package com.example.brand.domain.repo

import com.example.brand.domain.model.PhoneDomainModel

interface IPhoneRepo {
    suspend fun getPhoneDomainModel(): PhoneDomainModel
}