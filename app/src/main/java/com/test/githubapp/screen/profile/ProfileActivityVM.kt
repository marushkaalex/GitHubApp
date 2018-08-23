package com.test.githubapp.screen.profile

import android.databinding.ObservableField
import com.test.githubapp.base.ActivityViewModel

class ProfileActivityVM : ActivityViewModel() {

    val login = ObservableField<String>("")
    val avatarUrl = ObservableField<String>("")

    fun init(login: String?, avatarUrl: String?) {
        this.login.set(login)
        this.avatarUrl.set(avatarUrl)
    }
}