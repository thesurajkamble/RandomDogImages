package com.kamblesuraj.dogimagegenerator.data.di

import android.content.Context
import androidx.room.Room
import coil.Coil
import com.kamblesuraj.dogimagegenerator.data.api.DogApiService
import com.kamblesuraj.dogimagegenerator.data.local.DogsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(com.kamblesuraj.dogimagegenerator.BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): DogApiService =
        retrofit.create(DogApiService::class.java)


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        DogsDatabase::class.java,
        "randomDogs_table"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: DogsDatabase) = db.getDogsDao()


}