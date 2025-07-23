package com.example.myapplication.core.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.core.network.NewsApiService
import com.example.myapplication.feature.home.data.NewsRepoImp
import com.example.myapplication.feature.home.data.local.DAO
import com.example.myapplication.feature.home.data.local.NewsDb
import com.example.myapplication.feature.home.data.remote.RemoteDataSource
import com.example.myapplication.feature.home.domain.INewRepo
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
    fun provideApiService(retrofit: Retrofit):NewsApiService{
        return retrofit.create(NewsApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsRepo(remoteDataSource: RemoteDataSource): INewRepo {
        return NewsRepoImp(remoteDataSource)
    }

    @Singleton
    @Provides
    fun provideDao(
        db:NewsDb
    ):DAO{
        return db.dao
    }

    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext context:Context
    ):NewsDb{
        return Room.databaseBuilder(
            context = context.applicationContext,
            name = "gym_db",
            klass = NewsDb::class.java
        ).fallbackToDestructiveMigration(true).build()
    }
}