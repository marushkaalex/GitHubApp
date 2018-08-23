package com.test.githubapp.screen.search

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.test.githubapp.App
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.ActivityViewModel
import com.test.githubapp.base.RecyclerBindingAdapter
import com.test.githubapp.base.RecyclerConfiguration
import com.test.githubapp.binding.SingleLiveEvent
import com.test.githubapp.data.Repository
import com.test.githubapp.di.ComponentHolder
import com.test.githubapp.model.RepoModel
import com.test.githubapp.screen.profile.ProfileActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class SearchActivityVM : ActivityViewModel() {

    @Inject
    lateinit var repository: Repository

    val inputText = ObservableField("")
    val recyclerConfiguration = RecyclerConfiguration()
    val foundItems = ObservableArrayList<RepoModel>()
    val isSearching = ObservableField<Boolean>()
    val showEmptyQueryMessage = SingleLiveEvent<Unit>()
    val hideKeyboard = SingleLiveEvent<Unit>()
    val errorEvent = SingleLiveEvent<String>()
    val notSearchedYet = ObservableBoolean(true)

    init {
        ComponentHolder.getViewModelComponent().inject(this)
    }

    override fun onCreate() {
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
            try {
                val res = repository.searchRepositories(query).await()
                foundItems.addAll(res.items)
                isSearching.set(false)
            } catch (e: Exception) {
                errorEvent.postValue(e.message)
            } finally {
                isSearching.set(false)
                notSearchedYet.set(false)
            }
        }
    }

    private fun getAdapter(): RecyclerBindingAdapter<RepoModel> {
        val adapter = RecyclerBindingAdapter(R.layout.item_repo, BR.item, foundItems).apply {
            onItemClickListener = { _, item ->
                ProfileActivity.open(App.instance, item.owner?.login, item.owner?.avatarUrl)
            }
        }
        return adapter
    }

    private fun initRecycler() {
        val adapter = getAdapter()

        recyclerConfiguration.layoutManager = LinearLayoutManager(App.instance)
        recyclerConfiguration.itemAnimator = DefaultItemAnimator()
        recyclerConfiguration.adapter = adapter
    }
}