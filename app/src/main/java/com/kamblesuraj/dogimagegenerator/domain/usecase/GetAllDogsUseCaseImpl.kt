package com.kamblesuraj.dogimagegenerator.domain.usecase

import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel
import com.kamblesuraj.dogimagegenerator.domain.repository.RandomDogsRepository
import javax.inject.Inject

class GetAllDogsUseCaseImpl @Inject constructor(
   private val repository: RandomDogsRepository
):GetAllDogsUseCase {
    override suspend fun execute(): Resource<List<RandomDogsModel>> {
        return repository.getAllDogs()
    }
}