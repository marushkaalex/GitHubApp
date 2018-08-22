package com.test.githubapp.screen.profile

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.test.githubapp.BR
import com.test.githubapp.R
import com.test.githubapp.base.BindingActivity
import com.test.githubapp.databinding.ActivityProfileBinding

class ProfileActivity : BindingActivity<ActivityProfileBinding, ProfileActivityVM>()  {

    companion object {
        private const val EXTRA_LOGIN = "login"
        private const val EXTRA_AVATAR_URL = "avatar_url"

        fun open(context: Context, login: String?, avatarUrl: String?) {
            val intent = Intent(context, ProfileActivity::class.java).apply {
                putExtra(EXTRA_LOGIN, login)
                putExtra(EXTRA_AVATAR_URL, avatarUrl)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(): ProfileActivityVM {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val login = intent.getStringExtra(EXTRA_LOGIN)
        val avatarUrl = intent.getStringExtra(EXTRA_AVATAR_URL)
        return ProfileActivityVM(this, login, avatarUrl)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            getViewModel().finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun getVariable() = BR.viewModel

    override fun getLayoutId() = R.layout.activity_profile
}