package com.example.brand.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brand.domain.usecase.PhoneUseCase
import com.example.brand.ui.model.UiModel
import com.example.brand.ui.model.toUiModel
import com.example.brand.ui.util.ApiCode
import com.example.brand.ui.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhoneViewModel @Inject constructor(private val phoneUseCase: PhoneUseCase) : ViewModel() {
    private val _phoneBrand: MutableStateFlow<UiModel?> = MutableStateFlow(null)
    var phoneBrand: StateFlow<UiModel?> = _phoneBrand
    private val _phoneName: MutableStateFlow<String> = MutableStateFlow("")
    var phoneName: StateFlow<String> = _phoneName
    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    var error: StateFlow<String?> = _error
    private val _dataState = MutableStateFlow<DataState>(DataState.Success("Success Stata"))
    var dataState: StateFlow<DataState> = _dataState
    fun getPhonesBrand() {
        viewModelScope.launch {
            _phoneBrand.emit(phoneUseCase.getPhoneUseCase().toUiModel())
        }
    }

    fun getPhoneName() {
        viewModelScope.launch {
            when (val result = phoneUseCase.execute(phoneName.value)) {
                is ApiCode.NetWorkError -> {
                    _dataState.value = DataState.NetWorkError(result.message.toString())
                }
                is ApiCode.NotFound -> _dataState.value =
                    DataState.NotFound(result.message.toString())
                is ApiCode.Success -> {
                    _phoneName.value = result.data.toString()
                    _dataState.value = DataState.Success(result.data.toString())
                }
            }
        }
    }
}