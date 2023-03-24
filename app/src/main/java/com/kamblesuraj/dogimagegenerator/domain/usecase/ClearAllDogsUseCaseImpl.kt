package com.kamblesuraj.dogimagegenerator.domain.usecase

import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.domain.repository.RandomDogsRepository
import javax.inject.Inject

class ClearAllDogsUseCaseImpl @Inject constructor(
    private val repository: RandomDogsRepository
) : ClearAllDogsUseCase {
    override suspend fun execute(): Resource<Boolean> {
        return repository.clearAllDogs()
    }

}