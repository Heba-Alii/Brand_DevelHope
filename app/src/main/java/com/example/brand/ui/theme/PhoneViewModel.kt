package com.example.brand.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brand.domain.usecase.PhoneUseCase
import com.example.brand.ui.model.UiModel
import com.example.brand.ui.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhoneViewModel @Inject constructor(private val phoneUseCase: PhoneUseCase) : ViewModel() {
    private val _phoneBrand: MutableStateFlow<UiModel?> = MutableStateFlow(null)
    var phoneBrand: StateFlow<UiModel?> = _phoneBrand
    fun getPhonesBrand() {
        viewModelScope.launch {
            _phoneBrand.emit(phoneUseCase.getPhoneUseCase().toUiModel())
        }
    }
}