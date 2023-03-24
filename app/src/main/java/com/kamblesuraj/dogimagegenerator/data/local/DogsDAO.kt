package com.kamblesuraj.dogimagegenerator.data.local

import androidx.room.*
import com.kamblesuraj.dogimagegenerator.domain.entities.RandomDogsModel

@Dao
interface DogsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDogs(randomDogs: RandomDogsModel)

    @Delete
    fun deleteDogs(randomDogs: RandomDogsModel)

    @Query("SELECT * FROM randomDogs_table")
    fun getAllDogs(): List<RandomDogsModel>

    @Query("DELETE FROM randomDogs_table")
    fun clearDogs()
}