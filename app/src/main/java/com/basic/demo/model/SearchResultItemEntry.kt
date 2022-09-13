package com.basic.demo.model

import java.io.Serializable

data class RepoEntity(
    val full_name: String?,
    val description: String?,
    val stargazers_count: Int?,
    val language: String?,
    val id: Long?,
    val node_id: String?,
    val name: String?,
    val owner: Owner,
    val html_url: String?,
    val fork: Boolean,
    val url: String?,
    val forks_url: String?,
    val keys_url: String?,
    val license: License?,
) : Serializable

data class Owner(
    val login: String?,
    val avatar_url: String?,
    val html_url: String?,
) : Serializable

data class License(
    val spdx_id: String?,
) : Serializable

