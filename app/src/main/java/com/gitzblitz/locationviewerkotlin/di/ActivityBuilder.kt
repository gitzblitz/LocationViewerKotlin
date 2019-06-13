package com.gitzblitz.locationviewerkotlin.di

import com.gitzblitz.locationviewerkotlin.locationlist.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainListActivity(): MainActivity
}