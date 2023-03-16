package com.kamblesuraj.dogimagegenerator.data.api

import com.kamblesuraj.dogimagegenerator.data.models.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getDogImages(
    ): Response<DataResponse>
}