package com.gitzblitz.locationviewerkotlin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gitzblitz.locationviewerkotlin.model.Location
import com.gitzblitz.locationviewerkotlin.utils.Converters

@Database(entities = arrayOf(Location::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun locationDao():LocationDao


}