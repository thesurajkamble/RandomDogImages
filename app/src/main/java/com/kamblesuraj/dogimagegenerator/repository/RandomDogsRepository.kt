package com.kamblesuraj.dogimagegenerator.repository

import com.kamblesuraj.dogimagegenerator.data.model.RandomDogsResponse
import com.kamblesuraj.dogimagegenerator.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RandomDogsRepository {
    suspend fun getRandomDogs(): Resource<RandomDogsResponse>
}