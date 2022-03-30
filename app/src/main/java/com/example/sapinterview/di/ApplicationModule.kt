package com.example.sapinterview.di

import android.content.Context
import com.example.sapinterview.base.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApplicationModule @Inject constructor(val application: MyApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }
}