package com.example.brand.data.repo

import com.example.brand.data.dataSource.remote.PhoneRemoteDataSource
import com.example.brand.data.model.toDomainModel
import com.example.brand.domain.model.PhoneDomainModel
import com.example.brand.domain.repo.IPhoneRepo

class RepoImpl(private val phoneRemoteDataSource: PhoneRemoteDataSource):IPhoneRepo {
    override suspend fun getPhoneDomainModel(): PhoneDomainModel {
        return phoneRemoteDataSource.getPhonesDataModel().toDomainModel()
    }
}