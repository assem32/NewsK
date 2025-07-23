package com.example.myapplication.feature.home.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.feature.home.domain.entity.NewsItemEntity

@Database (
    entities = [NewsItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDb :RoomDatabase(){
    abstract val dao: DAO


    companion object {
        var daoInstance: DAO? = null

        private fun buildDb(context: Context): NewsDb =
            Room.databaseBuilder(
                context = context.applicationContext,
                name = "new_db",
                klass = NewsDb::class.java
            ).fallbackToDestructiveMigration(true).build()


        fun getInstance(context: Context): DAO {
            synchronized(this) {
                if (daoInstance == null) {
                    daoInstance = buildDb(context).dao
                }
                return daoInstance as DAO
            }
        }


    }
}