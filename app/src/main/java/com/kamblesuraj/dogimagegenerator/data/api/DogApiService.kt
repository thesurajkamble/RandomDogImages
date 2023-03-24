package com.kamblesuraj.dogimagegenerator.data.api

import com.kamblesuraj.dogimagegenerator.data.dto.DogsDto
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {
    @GET("/api/breeds/image/random")
    suspend fun getRandomDog(): Response<DogsDto>
}