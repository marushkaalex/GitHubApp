package com.test.githubapp.screen.search

import android.arch.lifecycle.Observer
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.BindingActivity
import com.test.githubapp.databinding.ActivitySearchBinding
import com.test.githubapp.util.hideSoftKeyboard

class SearchActivity : BindingActivity<ActivitySearchBinding, SearchActivityVM>() {
    override fun onCreate(): SearchActivityVM {
        val vm = SearchActivityVM(this)

        vm.showEmptyQueryMessage.observe(this, Observer {
            Toast
                    .makeText(this, R.string.search_emptyQueryMessage, Toast.LENGTH_SHORT)
                    .show()
        })

        vm.hideKeyboard.observe(this, Observer {
            hideSoftKeyboard()
        })

        vm.errorEvent.observe(this, Observer {
            AlertDialog.Builder(this@SearchActivity)
                    .setMessage(it)
                    .setPositiveButton(R.string.common_ok, null)
                    .show()
        })

        return vm
    }

    override fun getVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_search
}