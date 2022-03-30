package com.example.sapinterview.di

import com.example.sapinterview.ui.UserViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApplicationModule::class])
interface ApplicationComponent {

    fun viewModelFactory(): ViewModelFactory<UserViewModel>
}