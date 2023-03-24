package com.kamblesuraj.dogimagegenerator.domain.repository

import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel

interface RandomDogsRepository {
    suspend fun getRandomDogs(): Resource<RandomDogsModel>

    suspend fun getAllDogs():Resource<List<RandomDogsModel>>

    suspend fun clearAllDogs():Resource<Boolean>
}