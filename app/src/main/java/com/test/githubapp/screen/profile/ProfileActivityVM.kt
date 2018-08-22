package com.test.githubapp.screen.profile

import android.databinding.ObservableField
import com.test.githubapp.base.ActivityViewModel

class ProfileActivityVM(
        activity: ProfileActivity,
        login: String?,
        avatarUrl: String?
) : ActivityViewModel<ProfileActivity>(activity) {

    val login = ObservableField<String>(login)
    val avatarUrl = ObservableField<String>(avatarUrl)
}