package com.test.githubapp.di.component

import com.test.githubapp.di.module.RepositoryModule
import com.test.githubapp.search.SearchActivityVM
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface ViewModelComponent {

    fun inject(vm: SearchActivityVM)
}