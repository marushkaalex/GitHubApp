package com.test.githubapp.data

import com.test.githubapp.model.ListResultModel
import com.test.githubapp.model.RepoModel
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String, @Query("per_page") perPage: Int)
            : Deferred<ListResultModel<RepoModel>>
}