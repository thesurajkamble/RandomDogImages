package com.kamblesuraj.dogimagegenerator.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.data.repository.MainDogsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    private val randomDogsRepository: MainDogsRepositoryImpl
) : ViewModel() {
    sealed class UiStateEvents {
        class Success(val resultText: String) : UiStateEvents()
        class Failure(val errorText: Exception) : UiStateEvents()
        object Loading : UiStateEvents()
        object Empty : UiStateEvents()
    }

    private val _uiState = MutableStateFlow<UiStateEvents>(UiStateEvents.Empty)
    val uiState: StateFlow<UiStateEvents> = _uiState
    fun getRandomDogImages() {
        _uiState.value = UiStateEvents.Empty
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiStateEvents.Loading
            when (val dogsResponse = randomDogsRepository.getRandomDogs()) {
                is Resource.Error -> _uiState.value = UiStateEvents.Failure(dogsResponse.message!!)
                is Resource.Success -> {
                    _uiState.value = UiStateEvents.Success(dogsResponse.data?.imageUrl.toString())
                    val log = dogsResponse.data?.imageUrl.toString()
                    Log.d("VIEWMODEL_TAG",log)
                }
            }
        }
    }
}