package com.fioalpha.poc.domain.model

data class RepoGitHub(
    val name: String,
    val stars: Int,
    val forks: Int,
    val user: User
)

data class User (
    val picture: String,
    val name: String,

)