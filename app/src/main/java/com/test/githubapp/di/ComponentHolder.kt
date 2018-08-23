package com.test.githubapp.di

import com.test.githubapp.di.component.*

object ComponentHolder {
    private var networkComponent: NetworkComponent? = null
    private var searchActivityComponent: SearchActivityComponent? = null
    private var viewComponent: ViewComponent? = null
    private var viewModelComponent: ViewModelComponent? = null

    fun getNetworkComponent(): NetworkComponent {
        if (networkComponent == null) {
            networkComponent = DaggerNetworkComponent.create()
        }
        return networkComponent!!
    }

    fun clearNetworkComponent() {
        networkComponent = null
    }

    fun getSearchActivityComponent(): SearchActivityComponent {
        if (searchActivityComponent == null) {
            searchActivityComponent = DaggerSearchActivityComponent.create()
        }
        return searchActivityComponent!!
    }

    fun clearSearchActivityComponent() {
        searchActivityComponent = null
    }

    fun getViewComponent(): ViewComponent {
        if (viewComponent == null) {
            viewComponent = DaggerViewComponent.create()
        }
        return viewComponent!!
    }

    fun clearViewComponent() {
        viewComponent = null
    }

    fun getViewModelComponent(): ViewModelComponent {
        if (viewModelComponent == null) {
            viewModelComponent = DaggerViewModelComponent.create()
        }
        return viewModelComponent!!
    }

    fun clearViewModelComponent() {
        viewModelComponent = null
    }
}