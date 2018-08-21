package com.test.githubapp.model

import com.google.gson.annotations.SerializedName

data class ListResultModel<T>(
        @SerializedName("total_count") val totalCount: Long,
        val items: List<T>
)