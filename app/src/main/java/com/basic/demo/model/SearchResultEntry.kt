package com.basic.demo.model

import java.io.Serializable

data class SearchResultEntry(
    val incomplete_results: Boolean = false,
    val items: MutableList<RepoEntity>?=null,
    val total_count: Int = 0,
    var page: Int = 1,
    var isLoadMore: Boolean = true,
    var success: Boolean = true
) :Serializable