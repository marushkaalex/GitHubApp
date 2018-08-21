package com.test.githubapp.search

import android.arch.lifecycle.Observer
import android.widget.Toast
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.BindingActivity
import com.test.githubapp.databinding.ActivitySearchBinding

class SearchActivity : BindingActivity<ActivitySearchBinding, SearchActivityVM>() {
    override fun onCreate(): SearchActivityVM {
        val vm = SearchActivityVM(this)
        vm.showEmptyQueryMessage.observe(this, Observer {
            Toast
                    .makeText(this, R.string.search_emptyQueryMessage, Toast.LENGTH_SHORT)
                    .show()
        })
        return vm
    }

    override fun getVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_search
}