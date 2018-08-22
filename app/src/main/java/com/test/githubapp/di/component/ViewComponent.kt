package com.test.githubapp.di.component

import com.test.githubapp.di.module.VmModule
import com.test.githubapp.di.scope.SearchScope
import com.test.githubapp.screen.profile.ProfileActivity
import com.test.githubapp.screen.search.SearchActivity
import dagger.Component

@Component(modules = [VmModule::class])
interface ViewComponent {

//    @SearchScope
    fun inject(view: SearchActivity)

    fun inject(view: ProfileActivity)
}