package com.test.githubapp.search

import android.databinding.Observable
import android.databinding.ObservableField
import android.widget.Toast
import com.test.githubapp.base.ActivityViewModel

class SearchActivityVM(activity: SearchActivity) : ActivityViewModel<SearchActivity>(activity) {
    val inputText = ObservableField("123")

    init {
        inputText.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Toast.makeText(activity, inputText.get(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}