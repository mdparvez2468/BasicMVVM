package com.example.basicmvvm

import android.app.Application
import com.example.basicmvvm.di.ApplicationComponent
import com.example.basicmvvm.di.DaggerApplicationComponent


class FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()


    }
}