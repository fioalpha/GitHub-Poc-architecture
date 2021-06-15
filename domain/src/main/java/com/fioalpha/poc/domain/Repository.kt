package com.fioalpha.poc.domain

import com.fioalpha.poc.domain.model.RepoGitHub

interface Repository {
    suspend fun fetchRepoGutHub(page: Int): List<RepoGitHub>
}