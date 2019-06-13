package com.gitzblitz.locationviewerkotlin.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gitzblitz.locationviewerkotlin.locationlist.LocationListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LocationListViewModel::class)
    abstract fun provideLocationListViewModel(locationListViewModel: LocationListViewModel): ViewModel


}