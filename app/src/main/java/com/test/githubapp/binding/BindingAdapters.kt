package com.test.githubapp.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import com.test.githubapp.base.RecyclerConfiguration

@BindingAdapter("android:onClick")
fun View.bindOnClick(runnable: Runnable) {
    setOnClickListener { runnable.run() }
}

@BindingAdapter("app:configuration")
fun configureRecyclerView(recyclerView: RecyclerView, configuration: RecyclerConfiguration) {
    recyclerView.layoutManager = configuration.layoutManager
    recyclerView.itemAnimator = configuration.itemAnimator
    recyclerView.adapter = configuration.adapter
}