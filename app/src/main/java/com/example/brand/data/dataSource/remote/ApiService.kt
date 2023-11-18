package com.example.brand.data.dataSource.remote

import com.example.brand.data.model.PhoneDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService : IPhonesDataSource {
    @GET("")
    override fun getPhonesDataModel(): PhoneDataModel
}