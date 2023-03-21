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
import com.google.android.material.snackbar.Snackbar
import com.kamblesuraj.dogimagegenerator.databinding.ActivityImageGenerateBinding
import com.kamblesuraj.dogimagegenerator.viewmodel.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ImageGenerateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageGenerateBinding

    private val mainViewmodel: MainViewmodel by viewModels()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageGenerateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGenerateDogs.setOnClickListener {
//            mainViewmodel.getRandomDogImages()
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewmodel.uiState.collect { event ->
                    when (event) {
                        is MainViewmodel.UiStateEvents.Loading -> {
                            binding.progressBar.isVisible = true
                        }
                        is MainViewmodel.UiStateEvents.Failure -> {
                            binding.txtRes.text = "Something went wrong"
                        }
                        is MainViewmodel.UiStateEvents.Success -> {
                            binding.txtRes.text = event.resultText
                        }
                        else -> Unit
                    }
                }
            }
        }
    }
}