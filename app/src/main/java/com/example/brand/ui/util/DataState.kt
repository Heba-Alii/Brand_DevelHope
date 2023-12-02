package com.example.brand.ui.util

import android.provider.ContactsContract.Data

sealed class DataState {
    data class Success(val data: String) : DataState()
    data class NetWorkError(val message: String) : DataState()
    data class NotFound(val message: String) : DataState()
}
