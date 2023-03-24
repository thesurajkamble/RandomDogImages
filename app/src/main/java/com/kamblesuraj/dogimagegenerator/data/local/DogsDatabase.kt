package com.kamblesuraj.dogimagegenerator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel

@Database(entities = [RandomDogsModel::class], version = 1)
abstract class DogsDatabase : RoomDatabase() {
    abstract fun getDogsDao(): DogsDAO
}