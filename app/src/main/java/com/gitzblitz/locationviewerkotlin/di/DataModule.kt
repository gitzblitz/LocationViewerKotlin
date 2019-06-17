package com.gitzblitz.locationviewerkotlin.di

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gitzblitz.locationviewerkotlin.db.AppDatabase
import com.gitzblitz.locationviewerkotlin.db.LocationDao
import com.gitzblitz.locationviewerkotlin.db.LocationRepository
import com.gitzblitz.locationviewerkotlin.db.MockData
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesAppDatabase(context: Context): AppDatabase {

        return Room.databaseBuilder(context, AppDatabase::class.java, "location_database")
            .addCallback(object : RoomDatabase.Callback() {
                @SuppressLint("CheckResult")
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val mockData = MockData()
                    Single.fromCallable {
                        providesAppDatabase(context).locationDao().insert(mockData.generateLocations())
                    }.subscribeOn(Schedulers.io())
                        .subscribe({

                            Log.d("CALLBACK", "Data inserted")
                        }, {
                            it.printStackTrace()
                        })

                }
            })
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun providesLocationDao(appDatabase: AppDatabase) = appDatabase.locationDao()

    @Provides
    @Singleton
    fun provideRepository(locationDao: LocationDao) = LocationRepository(locationDao)


}