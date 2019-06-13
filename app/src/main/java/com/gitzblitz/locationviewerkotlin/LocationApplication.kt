package com.gitzblitz.locationviewerkotlin

import android.app.Activity
import android.app.Application
import com.gitzblitz.locationviewerkotlin.di.AppComponent
import com.gitzblitz.locationviewerkotlin.di.AppModule
import com.gitzblitz.locationviewerkotlin.di.DaggerAppComponent
import com.gitzblitz.locationviewerkotlin.di.DataModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LocationApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        initDi()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }


    private fun initDi() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .build()
    }
    companion object {

        @JvmStatic
        lateinit var appComponent: AppComponent
    }
}