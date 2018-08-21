package com.test.githubapp.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH
import android.widget.EditText
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

@BindingAdapter("app:onSearchInSoftKeyboard")
fun EditText.bindOnSearchInSoftKeyboardListener(runnable: Runnable?) {
    if (runnable == null) {
        setOnEditorActionListener(null)
    } else {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == IME_ACTION_SEARCH) {
                runnable.run()
                return@setOnEditorActionListener true
            } else {
                return@setOnEditorActionListener false
            }
        }
    }
}