package com.test.githubapp.base

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.widget.RecyclerView
import com.test.githubapp.BR

class RecyclerConfiguration : BaseObservable() {

    @get:Bindable
    var layoutManager: RecyclerView.LayoutManager? = null
        set(layoutManager) {
            field = layoutManager
            notifyPropertyChanged(BR.layoutManager)
        }

    @get:Bindable
    var itemAnimator: RecyclerView.ItemAnimator? = null
        set(itemAnimator) {
            field = itemAnimator
            notifyPropertyChanged(BR.itemAnimator)
        }

    @get:Bindable
    var adapter: RecyclerView.Adapter<*>? = null
        set(adapter) {
            field = adapter
            notifyPropertyChanged(BR.adapter)
        }
}
