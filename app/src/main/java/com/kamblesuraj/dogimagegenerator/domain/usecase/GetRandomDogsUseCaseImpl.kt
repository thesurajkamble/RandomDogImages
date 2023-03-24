package com.kamblesuraj.dogimagegenerator.domain.usecase

import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel
import com.kamblesuraj.dogimagegenerator.domain.repository.RandomDogsRepository
import javax.inject.Inject

class GetRandomDogsUseCaseImpl @Inject constructor(
    private val repository: RandomDogsRepository
): GetRandomDogsUseCase {
    override suspend fun execute(): Resource<RandomDogsModel> {
       return repository.getRandomDogs()
    }
}