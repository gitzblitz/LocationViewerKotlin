package com.gitzblitz.locationviewerkotlin.db

import androidx.paging.DataSource
import com.gitzblitz.locationviewerkotlin.model.Location
import io.reactivex.Single
import javax.inject.Inject

class LocationRepository @Inject constructor(private val locationDao: LocationDao) {


    fun getAllLocations(): DataSource.Factory<Int, Location> =
        locationDao.getAllLocations()

    fun updateLocation(location: Location): Single<Int> {
        return locationDao.updateLocation(location)
    }

}