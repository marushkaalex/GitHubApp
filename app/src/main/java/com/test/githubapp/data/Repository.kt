package com.test.githubapp.data

import com.test.githubapp.model.ListResultModel
import com.test.githubapp.model.RepoModel
import kotlinx.coroutines.experimental.Deferred

interface Repository {

    fun searchRepositories(query: String): Deferred<ListResultModel<RepoModel>>
}