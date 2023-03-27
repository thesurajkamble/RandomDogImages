package com.kamblesuraj.dogimagegenerator.presentation

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.*
import coil.Coil
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.kamblesuraj.dogimagegenerator.databinding.ActivityImageGenerateBinding
import com.kamblesuraj.dogimagegenerator.presentation.viewmodel.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ImageGenerateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageGenerateBinding

    private lateinit var  coil: Coil

    private val mainViewmodel: MainViewmodel by viewModels()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageGenerateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerateDogs.setOnClickListener {
            mainViewmodel.getRandomDogImages()
        }

        lifecycleScope.launch {
            mainViewmodel.uiState.collect { event ->
                when (event) {

                    is MainViewmodel.UiStateEvents.Loading -> {
                        binding.progressBar.isVisible = true
                    }

                    is MainViewmodel.UiStateEvents.Failure -> {
                        binding.txtRes.text = event.errorText.toString()
                        binding.progressBar.isVisible = false
                    }

                    is MainViewmodel.UiStateEvents.Success -> {
//                        binding.txtRes.text = event.resultText
                        binding.ivDogImg.load(event.resultText)
                        binding.progressBar.isVisible = false
                    }
                    else -> Unit
                }
            }
        }
    }
}


