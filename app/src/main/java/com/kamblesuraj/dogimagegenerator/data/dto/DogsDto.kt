package com.kamblesuraj.dogimagegenerator.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogsDto(
    @Json(name = "message") val imageUrl: String?,
    @Json(name = "status") val status: String?
)