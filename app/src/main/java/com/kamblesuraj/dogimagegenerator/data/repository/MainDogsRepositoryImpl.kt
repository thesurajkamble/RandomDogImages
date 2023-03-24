package com.kamblesuraj.dogimagegenerator.data.repository

import com.kamblesuraj.dogimagegenerator.common.data.BaseRepository
import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.data.api.DogApiService
import com.kamblesuraj.dogimagegenerator.data.local.DogsDAO
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel
import com.kamblesuraj.dogimagegenerator.domain.mapper.DogsMapper
import com.kamblesuraj.dogimagegenerator.domain.repository.RandomDogsRepository
import javax.inject.Inject

class MainDogsRepositoryImpl @Inject constructor(
    private val apiService: DogApiService,
    private val dao: DogsDAO
) : RandomDogsRepository, BaseRepository() {

    private suspend fun insertIntoDB(resource: Resource<RandomDogsModel>) {
        when (resource) {
            is Resource.Success -> {
                resource.data?.let {
                    val allDogs = dao.getAllDogs()
                    if (allDogs.size >= 21) {
                        val lastDog = allDogs.last()
                        dao.deleteDogs(lastDog)
                    }
                    dao.insertDogs(it)
                }
            }
            else -> Unit
        }
    }

    override suspend fun getRandomDogs(): Resource<RandomDogsModel> {
        val result = safeApiCall({ apiService.getRandomDog() }, DogsMapper)
        insertIntoDB(result)
        return result
    }

    override suspend fun getAllDogs(): Resource<List<RandomDogsModel>> {
        return try {
            val result = dao.getAllDogs()
            println(result)
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(Exception(e.localizedMessage))
        }
    }

    override suspend fun clearAllDogs(): Resource<Boolean> {
        return try {
            dao.clearDogs()
            Resource.Success(true)
        } catch (e: Exception) {
            Resource.Error(Exception(e.localizedMessage))
        }
    }
}