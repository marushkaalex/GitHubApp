package com.test.githubapp.search

import android.databinding.ObservableField
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.ActivityViewModel
import com.test.githubapp.base.RecyclerBindingAdapter
import com.test.githubapp.base.RecyclerConfiguration
import com.test.githubapp.binding.SingleLiveEvent
import com.test.githubapp.model.RepoModel

class SearchActivityVM(activity: SearchActivity) : ActivityViewModel<SearchActivity>(activity) {
    val inputText = ObservableField("")
    val recyclerConfiguration = RecyclerConfiguration()
    private val foundItems = mutableListOf<RepoModel>()
    val isSearching = ObservableField<Boolean>()
    val showEmptyQueryMessage = SingleLiveEvent<Unit>()

    init {
        initRecycler()
    }

    fun search() {
        val query = inputText.get() ?: ""
        if (query.isEmpty()) {
            showEmptyQueryMessage.call()
            return
        }
        recyclerConfiguration.adapter?.notifyDataSetChanged()
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