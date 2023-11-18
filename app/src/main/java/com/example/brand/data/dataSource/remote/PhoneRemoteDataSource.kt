package com.example.brand.data.dataSource.remote

import com.example.brand.data.model.PhoneDataModel
import retrofit2.Response

class PhoneRemoteDataSource : IPhonesDataSource {
    override fun getPhonesDataModel(): PhoneDataModel {
        return PhoneDataModel("", 's')
    }
}