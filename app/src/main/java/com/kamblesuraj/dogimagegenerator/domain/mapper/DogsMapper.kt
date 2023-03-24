package com.kamblesuraj.dogimagegenerator.domain.mapper

import com.kamblesuraj.dogimagegenerator.data.dto.DogsDto
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel
import java.util.*

object DogsMapper : Mapper<DogsDto, RandomDogsModel> {
    override suspend fun map(input: DogsDto): RandomDogsModel {
        return RandomDogsModel(
            imageUrl = input.imageUrl.orEmpty(),
            status = input.status.orEmpty(),
            createdAt = Calendar.getInstance().timeInMillis
        )
    }
}