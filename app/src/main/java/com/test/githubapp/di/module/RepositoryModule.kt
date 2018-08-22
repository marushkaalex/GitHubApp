package com.test.githubapp.di.module

import com.test.githubapp.data.NetworkRepository
import com.test.githubapp.data.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(): Repository = NetworkRepository()
}