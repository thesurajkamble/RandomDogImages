package com.kamblesuraj.dogimagegenerator.domain.usecase

import com.kamblesuraj.dogimagegenerator.common.data.Resource
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel

interface GetRandomDogsUseCase : SuspendingUseCase<Resource<RandomDogsModel>>