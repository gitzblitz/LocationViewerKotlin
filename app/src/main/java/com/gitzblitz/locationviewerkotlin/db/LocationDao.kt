package com.gitzblitz.locationviewerkotlin.db

import androidx.paging.DataSource
import androidx.room.*
import com.gitzblitz.locationviewerkotlin.model.Location
import io.reactivex.Single

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(location: Location)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(locations: List<Location>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract fun insertLocation(location: Location): Single<Int>

    @Query("DELETE FROM location")
    fun deleteAll()

    @Query("SELECT * FROM location")
    fun getAllLocations(): DataSource.Factory<Int, Location>

    @Transaction
    @Query("SELECT * FROM location WHERE uid=:locationID")
    fun getLocationById(locationID: Int): Single<Location>

    @Transaction
    @Update
    fun updateLocation(location: Location): Single<Int>
}