package com.kamblesuraj.dogimagegenerator.common.data

import android.util.Log
import com.kamblesuraj.dogimagegenerator.common.exception.UnknownException
import com.kamblesuraj.dogimagegenerator.domain.mapper.Mapper
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseRepository {
    open suspend fun <T, S> safeApiCall(
        api: suspend () -> Response<T>,
        mapper: Mapper<T, S>
    ): Resource<S> {
        try {
            val result = api()
            Log.d("MY_TAG_", result.toString())
            if (result.isSuccessful && result.body() != null) {
                result.body()?.let { body ->
                    return Resource.Success(mapper.map(body))
                }
            }
            return Resource.Error(UnknownException())
        } catch (e: Exception) {
            return Resource.Error(UnknownException())
        }
    }
}