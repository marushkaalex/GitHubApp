package com.test.githubapp.data

import com.test.githubapp.di.component.DaggerNetworkComponent
import javax.inject.Inject


class NetworkRepository : Repository {

    @Inject
    lateinit var gitHubService: GitHubService

    init {
        DaggerNetworkComponent.create().inject(this)
    }

    override fun searchRepositories(query: String) =
            gitHubService.searchRepositories(query, 100)
}