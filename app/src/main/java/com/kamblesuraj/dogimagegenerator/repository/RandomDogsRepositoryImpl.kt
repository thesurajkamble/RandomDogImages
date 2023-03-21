package com.kamblesuraj.dogimagegenerator.repository

import com.kamblesuraj.dogimagegenerator.data.api.DogApiService
import com.kamblesuraj.dogimagegenerator.data.model.RandomDogsResponse
import com.kamblesuraj.dogimagegenerator.data.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class RandomDogsRepositoryImpl @Inject constructor(
    private val DogApiService: DogApiService,
) : RandomDogsRepository {
    override suspend fun getRandomDogs(): Resource<RandomDogsResponse> {
        return try {
            val response = DogApiService.getDogImages()
            val res = response.body()
            if (response.isSuccessful && res != null) {
                Resource.Success(res)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
}