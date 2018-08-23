package com.test.githubapp.data

import com.test.githubapp.di.ComponentHolder
import javax.inject.Inject

class NetworkRepository : Repository {

    @Inject
    lateinit var gitHubService: GitHubService

    init {
        ComponentHolder.getNetworkComponent().inject(this)
    }

    override fun searchRepositories(query: String) =
            gitHubService.searchRepositories(query, 100)
}