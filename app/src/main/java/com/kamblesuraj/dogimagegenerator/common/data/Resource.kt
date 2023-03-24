package com.kamblesuraj.dogimagegenerator.common.data

sealed class Resource<T>(val data: T?, val message: Exception?) {
    class Success<T>(data: T) : Resource<T>(data, null)
    class Error<T>(message: Exception, data: T? = null): Resource<T>(null, message)
    object Loading
    object Empty
}