package com.example.brand.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.brand.R
import com.example.brand.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val phonesViewModel: PhoneViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  binding = ActivityMainBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.phoneView = phonesViewModel
        binding.lifecycleOwner = this
        //  setContentView(binding.root)
        phonesViewModel.getPhoneBrand()
//        lifecycleScope.launch {
//            phonesViewModel.phoneBrand.collect {
//            }
//        }
    }
}