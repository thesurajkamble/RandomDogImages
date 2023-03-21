package com.kamblesuraj.dogimagegenerator.data.model


import com.google.gson.annotations.SerializedName

data class RandomDogsResponse(
    @SerializedName("message")
    val url: String,
    @SerializedName("status")
    val status: String
)