package com.kamblesuraj.dogimagegenerator.domain.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "randomDogs_table")
data class RandomDogsModel(
    @PrimaryKey
    @ColumnInfo(name = "image_url", defaultValue = "")
    val imageUrl: String,
    @ColumnInfo(name = "status", defaultValue = "")
    val status: String,
    @ColumnInfo(name = "created_time")
    val createdAt: Long
)