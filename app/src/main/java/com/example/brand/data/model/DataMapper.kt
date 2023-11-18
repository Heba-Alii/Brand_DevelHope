package com.example.brand.data.model

import com.example.brand.domain.model.PhoneDomainModel

fun PhoneDataModel.toDomainModel(): PhoneDomainModel {
    return PhoneDomainModel(
        brandName = brandName ?: "",
        brandType = brandType!!
    )
}