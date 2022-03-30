package com.example.sapinterview.di

import com.example.sapinterview.base.MyApplication

class Injector {

    companion object {
        fun get() = MyApplication.applicationComponent
    }
}