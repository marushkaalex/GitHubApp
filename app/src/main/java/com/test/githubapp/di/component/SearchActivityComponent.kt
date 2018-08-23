package com.test.githubapp.di.component

import com.test.githubapp.di.module.SearchModule
import com.test.githubapp.di.scope.SearchScope
import com.test.githubapp.screen.search.SearchActivity
import dagger.Component

@SearchScope
@Component(modules = [SearchModule::class])
interface SearchActivityComponent {

    fun inject(view: SearchActivity)
}