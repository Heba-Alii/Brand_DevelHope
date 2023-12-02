package com.example.brand.data.repo

import com.example.brand.data.dataSource.remote.PhoneRemoteDataSource
import com.example.brand.data.model.toDomainModel
import com.example.brand.domain.model.PhoneDomainModel
import com.example.brand.domain.repo.IPhoneRepo
import com.example.brand.ui.util.ApiCode
import javax.inject.Inject
import kotlin.random.Random

class RepoImpl @Inject constructor(private val phoneRemoteDataSource: PhoneRemoteDataSource) :
    IPhoneRepo {
    override suspend fun getPhoneDomainModel(): PhoneDomainModel {
        return phoneRemoteDataSource.getPhonesDataModel().toDomainModel()
    }

    override suspend fun getPhoneName(name: String): ApiCode<Unit> {
        return if (Random.nextBoolean()) {
            ApiCode.Success(Unit)
        } else if (Random.nextBoolean()) {
            ApiCode.NotFound(message = "Phone Not Found", error = 404)
        } else {
            ApiCode.NetWorkError(message = "Network Error", error = 404)
        }
    }
}