package com.kamblesuraj.dogimagegenerator.domain.usecase

import com.kamblesuraj.dogimagegenerator.common.data.Resource

interface ClearAllDogsUseCase: SuspendingUseCase<Resource<Boolean>>