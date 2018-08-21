package com.test.githubapp.search

import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.ActivityViewModel
import com.test.githubapp.base.RecyclerBindingAdapter
import com.test.githubapp.base.RecyclerConfiguration
import com.test.githubapp.binding.SingleLiveEvent
import com.test.githubapp.data.Repository
import com.test.githubapp.model.RepoModel
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class SearchActivityVM(activity: SearchActivity) : ActivityViewModel<SearchActivity>(activity) {
    val inputText = ObservableField("")
    val recyclerConfiguration = RecyclerConfiguration()
    private val foundItems = ObservableArrayList<RepoModel>()
    val isSearching = ObservableField<Boolean>()
    val showEmptyQueryMessage = SingleLiveEvent<Unit>()
    val hideKeyboard = SingleLiveEvent<Unit>()

    init {
        initRecycler()
    }

    fun search() {
        val query = inputText.get() ?: ""
        if (query.isEmpty()) {
            showEmptyQueryMessage.call()
            return
        }
        hideKeyboard.call()
        foundItems.clear()
        launch(UI) {
            isSearching.set(true)
            val res = Repository.searchRepositories(query).await()
            foundItems.addAll(res.items)
            isSearching.set(false)
            println(res)
        }
    }

    private fun getAdapter(): RecyclerBindingAdapter<RepoModel> {
        val adapter = RecyclerBindingAdapter(R.layout.item_repo, BR.item, foundItems)
        return adapter
    }

    private fun initRecycler() {
        val adapter = getAdapter()

        recyclerConfiguration.layoutManager = LinearLayoutManager(activity)
        recyclerConfiguration.itemAnimator = DefaultItemAnimator()
        recyclerConfiguration.adapter = adapter
    }
}