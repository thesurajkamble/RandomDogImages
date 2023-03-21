package com.kamblesuraj.dogimagegenerator.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.kamblesuraj.dogimagegenerator.data.api.DogApiService
import com.kamblesuraj.dogimagegenerator.data.utils.Resource
import com.kamblesuraj.dogimagegenerator.repository.RandomDogsRepository
import com.kamblesuraj.dogimagegenerator.repository.RandomDogsRepositoryImpl
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    private val randomDogsRepository: RandomDogsRepositoryImpl,
    private val dogApiService: DogApiService,
) : ViewModel() {
    sealed class UiStateEvents {
        class Success(val resultText: String) : UiStateEvents()
        class Failure(val errorText: String) : UiStateEvents()
        object Loading : UiStateEvents()
        object Empty : UiStateEvents()
    }

    private val _uiState = MutableStateFlow<UiStateEvents>(UiStateEvents.Empty)
    val uiState: StateFlow<UiStateEvents> = _uiState
    fun getRandomDogImages() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiStateEvents.Loading
            when (val dogsResponse = randomDogsRepository.getRandomDogs()) {
                is Resource.Error -> _uiState.value = UiStateEvents.Failure(dogsResponse.message!!)
                is Resource.Success -> {
                    _uiState.value = UiStateEvents.Success(dogsResponse.data!!.url)
                }
            }
        }
    }
}