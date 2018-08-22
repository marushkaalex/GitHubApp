package com.test.githubapp.model

import com.google.gson.annotations.SerializedName

data class OwnerModel(
        val id: Long,
        val login: String,
        @SerializedName("avatar_url") val avatarUrl: String?
)