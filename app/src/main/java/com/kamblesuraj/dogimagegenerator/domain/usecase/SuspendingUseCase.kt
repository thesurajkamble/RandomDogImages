package com.kamblesuraj.dogimagegenerator.domain.usecase

interface SuspendingUseCase<  out Output> {
    suspend fun execute(): Output
}