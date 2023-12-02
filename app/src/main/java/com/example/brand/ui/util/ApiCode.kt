package com.example.brand.ui.util

sealed class ApiCode<T>(val data: T?, val message: String? = null, val error: Int? = null) {
    class Success<T>(data: T?) : ApiCode<T>(data)

    class NetWorkError<T>(data: T? = null, message: String, error: Int) :
        ApiCode<T>(data, message, error)

    class NotFound<T>(data: T? = null, message: String, error: Int) :
        ApiCode<T>(data, message, error)

}