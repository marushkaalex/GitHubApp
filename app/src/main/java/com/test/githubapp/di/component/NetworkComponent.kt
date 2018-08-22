package com.test.githubapp.di.component

import com.test.githubapp.data.NetworkRepository
import com.test.githubapp.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    @Singleton
    fun inject(repository: NetworkRepository)
}