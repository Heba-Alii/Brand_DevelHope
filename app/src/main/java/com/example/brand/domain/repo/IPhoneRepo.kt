package com.example.brand.domain.repo

import com.bumptech.glide.load.engine.Resource
import com.example.brand.domain.model.PhoneDomainModel
import com.example.brand.ui.util.ApiCode

interface IPhoneRepo {
    suspend fun getPhoneDomainModel(): PhoneDomainModel
    suspend fun getPhoneName(name: String): ApiCode<Unit>
}