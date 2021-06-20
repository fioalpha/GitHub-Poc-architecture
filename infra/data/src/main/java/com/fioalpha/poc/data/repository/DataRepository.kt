package com.fioalpha.poc.data.repository

import com.fioalpha.poc.data.service.Service
import com.fioalpha.poc.domain.Repository
import com.fioalpha.poc.domain.model.RepoGitHub
import com.fioalpha.poc.domain.model.User

class DataRepository(
    private val service: Service
): Repository{
    override suspend fun fetchRepoGutHub(page: Int): List<RepoGitHub> {
        return service.fetchRepo(page).items.map {
            RepoGitHub(
                name = it.full_name?: "",
                stars = it.stargazers_count?: 0,
                forks = it.fork_count?: 1,
                User(
                    it.owner?.avatar_url?: "",
                    it.owner?.login?: ""
                )
            )
        }
    }
}