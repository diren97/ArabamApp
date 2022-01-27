package com.direnaydin.arabamcom.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.direnaydin.arabamcom.R
import com.direnaydin.arabamcom.databinding.ActivityMainBinding
import com.direnaydin.arabamcom.presentation.ui.list.CarListViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.fragment)

    }
}