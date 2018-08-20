package com.test.githubapp.binding

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("android:onClick")
fun View.bindOnClick(runnable: Runnable) {
    setOnClickListener { runnable.run() }
}