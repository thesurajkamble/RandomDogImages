package com.kamblesuraj.dogimagegenerator.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class DogsDto(
    @SerializedName("message")
    val imageUrl: String?,
    @SerializedName("status")
    val status: String?
)