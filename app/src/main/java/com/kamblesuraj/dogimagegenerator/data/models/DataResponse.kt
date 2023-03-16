package com.kamblesuraj.dogimagegenerator.data.models


import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)