package com.fioalpha.poc.repo.presentation.model

data class RepoGithub(
    val repoName: String,
    val stars: Int,
    val forks: Int,
    val nameUser: String,
    val imagePath: String
)
