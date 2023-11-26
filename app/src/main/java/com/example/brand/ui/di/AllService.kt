package com.example.brand.ui.di

import com.example.brand.data.dataSource.remote.ApiService
import com.example.brand.data.dataSource.remote.Retrofit
import retrofit2.create

suspend fun ApiService.getPhones(retrofit: retrofit2.Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)

}