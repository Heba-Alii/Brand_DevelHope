package com.example.brand.data.dataSource.remote

import com.example.brand.data.model.PhoneDataModel
import retrofit2.Response

interface IPhonesDataSource {
    fun getPhonesDataModel(): PhoneDataModel
}