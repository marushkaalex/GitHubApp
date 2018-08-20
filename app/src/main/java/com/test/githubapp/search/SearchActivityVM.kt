package com.test.githubapp.search

import android.databinding.ObservableField
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.ActivityViewModel
import com.test.githubapp.base.RecyclerBindingAdapter
import com.test.githubapp.base.RecyclerConfiguration

class SearchActivityVM(activity: SearchActivity) : ActivityViewModel<SearchActivity>(activity) {
    val inputText = ObservableField("123")
    val recyclerConfiguration = RecyclerConfiguration()
    private val foundItems = arrayListOf("one", "two", "three")

    init {
        initRecycler()
    }

    fun search() {
        Toast.makeText(activity, inputText.get(), Toast.LENGTH_SHORT).show()
        foundItems.addAll(foundItems)
        recyclerConfiguration.adapter?.notifyDataSetChanged()
    }

    private fun getAdapter(): RecyclerBindingAdapter<String> {
        val adapter = RecyclerBindingAdapter<String>(R.layout.item_text, BR.item, foundItems)
        return adapter
    }

    private fun initRecycler() {
        val adapter = getAdapter()

        recyclerConfiguration.layoutManager = LinearLayoutManager(activity)
        recyclerConfiguration.itemAnimator = DefaultItemAnimator()
        recyclerConfiguration.adapter = adapter
    }
}