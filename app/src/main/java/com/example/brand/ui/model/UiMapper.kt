package com.example.brand.ui.model

import com.example.brand.R
import com.example.brand.domain.model.PhoneDomainModel

fun PhoneDomainModel.toUiModel(): UiModel {
    return UiModel(
        brandType = mapLetterToBrand(this.brandType)
    )
}

fun mapLetterToBrand(brandType: Char): Int {
    return when (brandType) {
        BrandType.IPHONE.firstChar -> R.string.iphone
        BrandType.SAMSUNG.firstChar -> R.string.samsung
        else -> R.string.unKnown
    }
}
