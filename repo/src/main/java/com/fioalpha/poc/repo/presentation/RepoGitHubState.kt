package com.fioalpha.poc.repo.presentation

import com.fioalpha.poc.repo.presentation.model.RepoGithub

sealed class RepoGitHubState {
    object Idle: RepoGitHubState()
    object Loader: RepoGitHubState()
    data class Result(val data: List<RepoGithub>): RepoGitHubState()
    data class Error(val error: String): RepoGitHubState()
}

sealed class RepoGitHubInteraction {
    object LoaderItems: RepoGitHubInteraction()
}

