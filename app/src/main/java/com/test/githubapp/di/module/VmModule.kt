package com.test.githubapp.di.module

import com.test.githubapp.screen.profile.ProfileActivityVM
import com.test.githubapp.screen.search.SearchActivityVM
import dagger.Module
import dagger.Provides

@Module
class VmModule {

    @Provides
    fun provideSearchVm() = SearchActivityVM()

    @Provides
    fun provideProfileVm() = ProfileActivityVM()
}