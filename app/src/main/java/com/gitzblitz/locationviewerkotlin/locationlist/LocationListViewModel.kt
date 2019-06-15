package com.gitzblitz.locationviewerkotlin.locationlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.gitzblitz.locationviewerkotlin.db.LocationRepository
import com.gitzblitz.locationviewerkotlin.model.Location
import javax.inject.Inject

class LocationListViewModel @Inject constructor (private val locationRepository: LocationRepository):ViewModel() {


//    init {
//        val locationList : LiveData<PagedList<Location>> =  LivePagedListBuilder(locationRepository.getAllLocations(), 20).build()
//    }


//    fun getAllLocations(): LiveData<PagedList<Location>> = LivePagedListBuilder(locationRepository.getAllLocations(), 20).build()
    fun getAllLocations(): LiveData<PagedList<Location>> = locationRepository.getAllLocations().toLiveData(pageSize = 20)






}