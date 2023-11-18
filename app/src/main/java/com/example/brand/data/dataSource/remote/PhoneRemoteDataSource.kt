package com.example.brand.data.dataSource.remote

import com.example.brand.data.model.PhoneDataModel
import javax.inject.Inject

class PhoneRemoteDataSource : IPhonesDataSource {

    override fun getPhonesDataModel(): PhoneDataModel {
        return PhoneDataModel("", 's')
    }
}