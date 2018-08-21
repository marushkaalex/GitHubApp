package com.test.githubapp.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager


fun Activity.hideSoftKeyboard() {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}