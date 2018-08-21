package com.test.githubapp.binding

import android.databinding.BindingConversion
import android.view.View

@BindingConversion
fun convertBooleanToVisibility(visible: Boolean) = if (visible) View.VISIBLE else View.GONE