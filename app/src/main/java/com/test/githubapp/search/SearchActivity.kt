package com.test.githubapp.search

import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.BindingActivity
import com.test.githubapp.databinding.ActivitySearchBinding

class SearchActivity : BindingActivity<ActivitySearchBinding, SearchActivityVM>() {
    override fun onCreate(): SearchActivityVM {
        return SearchActivityVM(this)
    }

    override fun getVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_search
}