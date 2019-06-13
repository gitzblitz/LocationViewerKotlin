package com.gitzblitz.locationviewerkotlin.di

import com.gitzblitz.locationviewerkotlin.LocationApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class),(DataModule::class),(ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
         fun application(application: LocationApplication): Builder
         fun appModule(appModule: AppModule): Builder
         fun dataModule(dataModule: DataModule): Builder
         fun build(): AppComponent
    }

    fun inject(locationApplication: LocationApplication)

}