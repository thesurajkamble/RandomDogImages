package com.kamblesuraj.dogimagegenerator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import coil.Coil
import coil.load
import com.kamblesuraj.dogimagegenerator.data.local.DogsDAO
import com.kamblesuraj.dogimagegenerator.data.local.DogsDatabase
import com.kamblesuraj.dogimagegenerator.databinding.ActivityHistoryBinding
import com.kamblesuraj.dogimagegenerator.presentation.viewmodel.MainViewmodel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryActivity : AppCompatActivity() {

//    @Inject
//    lateinit var coil: Coil

//    private lateinit var listAdaptor: ListAdaptor

//    private val viewModel: MainViewmodel by viewModels()
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        lifecycleScope.launch {
//            viewModel.uiState.collect { event ->
//                when (event) {
//
//                    is MainViewmodel.UiStateEvents.Loading -> {
//                        binding.progressBar.isVisible = true
//                    }
//
//                    is MainViewmodel.UiStateEvents.Failure -> {
//                        binding.progressBar.isVisible = false
//                    }
//
//                    is MainViewmodel.UiStateEvents.Success -> {
////                        binding.txtRes.text = event.resultText
//                        binding.ivDogHistory.load(event.resultText)
//                        binding.progressBar.isVisible = false
//                    }
//                    else -> Unit
//                }
//            }
//        }
    }
}