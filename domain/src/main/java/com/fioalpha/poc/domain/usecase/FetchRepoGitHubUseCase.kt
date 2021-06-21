package com.fioalpha.poc.domain.usecase

import com.fioalpha.poc.domain.Repository
import com.fioalpha.poc.domain.model.RepoGitHub

interface FetchRepoGitHubUseCase {
    suspend fun execute(page: Int): List<RepoGitHub>
}

class FetchRepoGitHubUseCaseImpl(
    private val repository: Repository
): FetchRepoGitHubUseCase {

    override suspend fun execute(page: Int): List<RepoGitHub> {
        return repository.fetchRepoGutHub(page)
    }

}