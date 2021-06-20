package com.fioalpha.poc.data.retrofit.model

data class GitHubRequest(
    val items: List<RepoItemRequest>
)

data class RepoItemRequest(
    val name: String?,
    val full_name: String?,
    val forks: Int?,
    val stargazers_count: Int?,
    val owner: OwnerRequest?
)

data class OwnerRequest(
    val avatar_url: String?,
    val login: String?
)
