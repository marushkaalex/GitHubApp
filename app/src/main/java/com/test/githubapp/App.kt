package com.test.githubapp

import android.app.Application
import com.test.githubapp.di.component.DaggerViewModelComponent
import com.test.githubapp.di.component.ViewModelComponent

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
        lateinit var viewModelComponent: ViewModelComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        viewModelComponent = DaggerViewModelComponent.create()
    }
}