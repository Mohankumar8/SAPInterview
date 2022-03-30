package com.example.sapinterview.base

import android.app.Application
import com.example.sapinterview.di.ApplicationComponent
import com.example.sapinterview.di.ApplicationModule
import com.example.sapinterview.di.DaggerApplicationComponent

class MyApplication: Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)).build()
    }
}