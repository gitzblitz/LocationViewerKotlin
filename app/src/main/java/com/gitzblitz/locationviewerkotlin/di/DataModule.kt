package com.gitzblitz.locationviewerkotlin.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gitzblitz.locationviewerkotlin.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule{

    @Provides
    @Singleton
    fun providesAppDatabase(context: Context): AppDatabase {

        return Room.databaseBuilder(context, AppDatabase::class.java, "location_database")
//            .addCallback(CALLBACK)
            .fallbackToDestructiveMigration()
            .build()
    }

    private val CALLBACK = object : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

        }
    }




}