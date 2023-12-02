package com.example.brand.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.brand.R
import com.example.brand.databinding.ActivityMainBinding
import com.example.brand.ui.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val phonesViewModel: PhoneViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.phoneView = phonesViewModel
        binding.lifecycleOwner = this
        phonesViewModel.getPhonesBrand()
        phonesViewModel.getPhoneName()
        lifecycleScope.launch {
            phonesViewModel.dataState.collect() {
                when (it) {
                    is DataState.Success -> {
                        binding.phoneText.text = it.data
                    }
                    is DataState.NotFound -> binding.phoneText.text = it.message
                    is DataState.NetWorkError -> binding.phoneText.text = it.message

                    else -> "Error"
                }
            }
        }
    }
}